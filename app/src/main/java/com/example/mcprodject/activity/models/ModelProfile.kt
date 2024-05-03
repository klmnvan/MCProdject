package com.example.mcprodject.activity.models

import kotlinx.serialization.Serializable

@Serializable
data class ModelProfile(
    val email: String,
    val name: String,
    val password: String,
    val passwordConfirm: String,
    val patronymic: String,
    val surname: String
)