package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.api.ApiService
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import com.cesi.ressourcesrelationnelles.data.model.RelationType
import com.cesi.ressourcesrelationnelles.data.model.UserRelation
import jakarta.inject.Inject

class RelationRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : RelationRepository {
    override suspend fun getUserRelations(id: Int, page: Int?, limit: Int?): List<UserRelationDto> {
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
        val response = apiService.getUserRelations(request)
        return response.data
    }

    override suspend fun getRelationTypes(): List<RelationType> {
        val searchRequest = SearchDto(
                filters = listOf(
                    FilterDto(
                        field = "type"
                    )
                )
        )
        val request = SearchRequestDto(searchRequest)
        val response = apiService.getUserRelations(request)
        return response.data
    }
}