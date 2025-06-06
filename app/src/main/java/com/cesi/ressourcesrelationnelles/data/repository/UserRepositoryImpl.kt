package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.api.ApiService
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.data.model.User
import jakarta.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): UserRepository {
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
        return response.data.first()
    }

    override suspend fun getUsers(
        filters: List<FilterDto>,
        page: Int?,
        limit: Int?
    ): List<UserDto> {
        val searchRequest = SearchDto(page = page ?: 1, limit = limit ?: 10, filters = filters)
        val request = SearchRequestDto(searchRequest)
        val response = apiService.getUsers(request)
        return response.data
    }

}