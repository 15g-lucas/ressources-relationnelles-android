package com.cesi.ressourcesrelationnelles.data.api

import com.cesi.ressourcesrelationnelles.data.dto.request.CreateUserDto
import com.cesi.ressourcesrelationnelles.data.dto.request.LoginDto
import com.cesi.ressourcesrelationnelles.data.dto.request.SearchRequestDto
import com.cesi.ressourcesrelationnelles.data.dto.response.CategoryDto
import com.cesi.ressourcesrelationnelles.data.dto.response.PaginatedResponseDto
import com.cesi.ressourcesrelationnelles.data.dto.response.RelationTypeDto
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.dto.response.TokenDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("users/search")
    suspend fun getUsers(
        @Body searchRequest: SearchRequestDto
    ): Response<PaginatedResponseDto<UserDto>>

    @POST("relations/search")
    suspend fun getUserRelations(
        @Body searchRequest: SearchRequestDto
    ): Response<PaginatedResponseDto<UserRelationDto>>

    @POST("resources/search")
    suspend fun getUserResources(
        @Body searchRequest: SearchRequestDto
    ): Response<PaginatedResponseDto<ResourceDto>>

    @POST("categories/search")
    suspend fun getResourceCategories(
        @Body searchRequest: SearchRequestDto
    ): Response<PaginatedResponseDto<CategoryDto>>

    @POST("register")
    suspend fun register(
        @Body user: CreateUserDto
    ): Response<UserDto>

    @POST("login")
    suspend fun login(
        @Body user: LoginDto
    ): Response<TokenDto>

    @POST("resources/search")
    suspend fun getResourcesByCategory(
        @Body searchRequest: SearchRequestDto
    ): Response<PaginatedResponseDto<ResourceDto>>

    @GET("me")
    suspend fun getMe(
    ): Response<UserDto>

}