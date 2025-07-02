package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.dto.request.CreateUserDto
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto

interface UserRepository {
    suspend fun getUsersById(id: Int): UserDto
    suspend fun getUsers(filters: List<FilterDto>, page: Int?, limit: Int?): List<UserDto>
    suspend fun register(user: CreateUserDto): UserDto
    suspend fun login(email: String, password: String): UserDto
}