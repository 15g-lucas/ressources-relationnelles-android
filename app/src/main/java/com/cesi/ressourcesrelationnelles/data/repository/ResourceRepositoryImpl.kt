package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.api.ApiService
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import jakarta.inject.Inject

class ResourceRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ResourceRepository {
    override suspend fun getUserResources(id: Int, page: Int?, limit: Int?): List<ResourceDto> {
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
        val response = apiService.getUserResources(request)
        return response.data
    }
}