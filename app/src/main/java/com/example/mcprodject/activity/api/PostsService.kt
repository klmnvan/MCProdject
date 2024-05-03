package com.example.mcprodject.activity.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface PostsService {

    suspend fun authorize (email: String, password: String): String?
    suspend fun registerUser (email: String, surname: String, name: String, patronymic: String,
        password: String, passwordConfirm: String ): String?

    companion object {
        fun create(): PostsService {
            return PostServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.BODY
                        filter { request ->
                            request.url.host.contains("iis.ngknn.ru")
                        }
                        sanitizeHeader { header ->
                            header == HttpHeaders.Authorization
                        }
                    }
                    /*Когда expectSuccess установлено в true, то при выполнении запроса к серверу,
                    HttpClient будет ожидать ответа с кодом состояния успешного завершения (2xx),
                    иначе будет сгенерировано исключение если ответ не соответствует условиям.*//*
                    expectSuccess = true*/
                    install(ContentNegotiation) {
                        json(
                            Json {
                                prettyPrint = true
                                isLenient = true
                                ignoreUnknownKeys = true
                            }
                        )
                    }
                }
            )
        }
    }

}