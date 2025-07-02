package com.cesi.ressourcesrelationnelles.data.api

import com.cesi.ressourcesrelationnelles.data.dto.request.CreateUserDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.PaginatedResponseDto
import com.cesi.ressourcesrelationnelles.data.dto.response.RelationTypeDto
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("users/search")
    suspend fun getUsers(
        @Body searchRequest: SearchRequestDto
    ): PaginatedResponseDto<UserDto>

    @POST("relations/search")
    suspend fun getUserRelations(
        @Body searchRequest: SearchRequestDto
    ): PaginatedResponseDto<UserRelationDto>

    @POST("resources/search")
    suspend fun getUserResources(
        @Body searchRequest: SearchRequestDto
    ): PaginatedResponseDto<ResourceDto>

    @POST("relations/search")
    suspend fun getRelationsType(
        @Body searchRequest: SearchRequestDto
    ): PaginatedResponseDto<RelationTypeDto>

    @POST("users/register")
    suspend fun register(
        @Body user: CreateUserDto
    ): UserDto
}