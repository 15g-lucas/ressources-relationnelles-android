package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.api.ApiService
import com.cesi.ressourcesrelationnelles.data.dto.request.CreateUserDto
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.request.LoginDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.TokenDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import jakarta.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {
    override suspend fun getUsersById(id: Int): UserDto {
        val searchRequest = SearchDto(
            filters = listOf(
                FilterDto(
                    field = "user_id",
                    operator = "eq",
                    value = id
                )
            )
        )
        val request = SearchRequestDto(searchRequest)
        val response = apiService.getUsers(request)
        if (response.isSuccessful) {
            return response.body()?.data?.first()
                ?: throw Exception("Erreur lors de la récupération des données")
        } else {
            throw Exception("Erreur lors de la récupération des données")
        }
    }

    override suspend fun getUsers(
        filters: List<FilterDto>,
        page: Int?,
        limit: Int?
    ): List<UserDto> {
        val searchRequest = SearchDto(page = page ?: 1, limit = limit ?: 10, filters = filters)
        val request = SearchRequestDto(searchRequest)
        val response = apiService.getUsers(request)
        if (response.isSuccessful) {
            return response.body()?.data
                ?: throw Exception("Erreur lors de la récupération des données")
        } else {
            throw Exception("Erreur lors de la récupération des données")
        }
    }

    override suspend fun register(user: CreateUserDto): UserDto {
        val response = apiService.register(user)
        if (!response.isSuccessful) {
            throw Exception("Erreur lors de la création de l'utilisateur")
        }
        return response.body() ?: throw Exception("Erreur lors de la création de l'utilisateur")
    }

    override suspend fun login(
        email: String,
        password: String
    ): TokenDto {
        val response = apiService.login(LoginDto(email, password))
        if (!response.isSuccessful) {
            throw Exception("Identifiants invalides")
        }
        return response.body() ?: throw Exception("Erreur lors de la connexion")
    }

    override suspend fun getMe(): UserDto {
        val response = apiService.getMe()
        if (!response.isSuccessful) {
            throw Exception("Erreur lors de la récupération des données")
        }
        return response.body() ?: throw Exception("Erreur lors de la récupération des données")
    }
}


