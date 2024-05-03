package com.example.mcprodject.activity.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import kotlinx.serialization.Serializable

@Suppress("UNUSED_EXPRESSION")
class PostServiceImpl(private val client: HttpClient): PostsService  {

    @Serializable
    data class ModelRegist(val email: String, val name: String, val password: String,
        val passwordConfirm: String, val patronymic: String, val surname: String)

    override suspend fun registerUser (email: String, surname: String, name: String, patronymic: String, password: String, passwordConfirm: String ): String? {
        return try {
            val response = client.post {
                url(HttpRoutes.REGISTER)
                contentType(ContentType.Application.Json)
                setBody(ModelRegist(email, name, password, passwordConfirm, patronymic, surname))
            }
            when(response.status.value){
                in 200..299 -> {
                    null
                }
                in 300..399 -> {
                    "Ошибка 3xx: ${response.body<String>()}"
                }
                in 400..499 -> {
                    if(response.body<String>().contains("Passwords must be at least 6 characters.")){
                        "Пароль должен быть больше 6 символов"
                    }
                    else if(response.body<String>().contains("Passwords must have at least one lowercase ('a'-'z').")){
                        "Пароль должен содержать символы ('a'-'z')"
                    }
                    else if(response.body<String>().contains("is already taken")){
                        "Почта уже зарегистрирована"
                    }
                    else if(response.body<String>().contains("Пароли не совпадают")){
                        "Пароли не совпадают"
                    }
                    else if(response.body<String>().contains("Длина пароля должна быть не менее 4 символов и не более 20")){
                        "Длина пароля должна быть не менее 4 символов и не более 20"
                    }
                    else response.body<String>()
                }
                in 500..599 -> {
                    "Ошибка 5xx: ${response.body<String>()}"
                }
            }
            response.body<String>()
        } catch (e: Exception) {
            Log.d("Exception","Error: ${e.message}")
            e.message
        }
    }

    @Serializable
    data class ModelAuth(val email: String, val password: String)

    override suspend fun authorize(email: String, password: String): String? {
        return try {
            val response = client.post {
                url(HttpRoutes.LOGIN)
                contentType(ContentType.Application.Json)
                setBody(ModelAuth(email, password))
            }
            when(response.status.value){
                in 200..299 -> {
                    null
                }
                in 300..399 -> {
                    "Ошибка 3xx: ${response.body<String>()}"
                }
                in 400..499 -> {
                    if(response.body<String>().contains("Invalid password")){
                        "Неверный пароль"
                    }
                    else if(response.body<String>().contains("Invalid email")){
                        "Неверная почта"
                    }
                    else {
                        response.body<String>()
                    }
                }
                in 500..599 -> {
                    "Ошибка 5xx: ${response.body<String>()}"
                }
                else -> { "Такого не может быть" }
            }
        } catch (e: Exception) {
            Log.d("Exception","Error: ${e.message}")
            e.message
        }
    }

}