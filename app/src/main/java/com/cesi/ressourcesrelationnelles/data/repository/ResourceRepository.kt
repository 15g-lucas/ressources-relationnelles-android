package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.dto.response.CategoryDto
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.model.Resource

interface ResourceRepository {
    suspend fun createResource(resource: Resource): ResourceDto
    suspend fun getCategories(): List<CategoryDto>
    suspend fun getUserResources(id: Int, page: Int?, limit: Int?): List<ResourceDto>
    suspend fun getResourcesByCategory(categoryId: Int): List<ResourceDto>
}