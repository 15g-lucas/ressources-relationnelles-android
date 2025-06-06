package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.model.Resource

interface ResourceRepository {
    suspend fun getUserResources(id: Int, page: Int?, limit: Int?): List<ResourceDto>
}