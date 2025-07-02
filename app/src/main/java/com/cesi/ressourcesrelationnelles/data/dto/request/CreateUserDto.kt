package com.cesi.ressourcesrelationnelles.data.dto.request

data class CreateUserDto(
    val username: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String
)