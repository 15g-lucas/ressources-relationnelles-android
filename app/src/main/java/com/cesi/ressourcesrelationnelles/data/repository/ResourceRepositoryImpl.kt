package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.api.ApiService
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.CategoryDto
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.model.Resource
import jakarta.inject.Inject

class ResourceRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ResourceRepository {
    override suspend fun createResource(resource: Resource): ResourceDto {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): List<CategoryDto> {
        val searchRequest = SearchDto(
            filters = listOf(
                FilterDto(
                    field = "type",
                    operator = "eq",
                    value = "category"
                )
            )
        )
        val request = SearchRequestDto(searchRequest)
        val response = apiService.getResourceCategories(request)
        if (response.isSuccessful) {
            return response.body()?.data ?: emptyList()
        } else {
            throw Exception("Erreur lors de la récupération des catégories")
        }
    }

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
        if (response.isSuccessful) {
            return response.body()?.data ?: emptyList()
        } else {
            throw Exception("Erreur lors de la récupération des ressources")
        }
    }

    override suspend fun getResourcesByCategory(categoryId: Int): List<ResourceDto> {
        val searchRequest = SearchDto(
            filters = listOf(
                FilterDto(
                    field = "category_id",
                    operator = "eq",
                    value = categoryId
                )
            )
        )
        val request = SearchRequestDto(searchRequest)
        val response = apiService.getResourcesByCategory(request)
        if (response.isSuccessful) {
            return response.body()?.data ?: emptyList()
        } else {
            throw Exception("Erreur lors de la récupération des ressources")
        }
    }
}