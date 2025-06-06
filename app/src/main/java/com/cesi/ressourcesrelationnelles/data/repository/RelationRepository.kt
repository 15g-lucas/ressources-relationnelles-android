package com.cesi.ressourcesrelationnelles.data.repository

import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import com.cesi.ressourcesrelationnelles.data.model.RelationType
import com.cesi.ressourcesrelationnelles.data.model.UserRelation

interface RelationRepository {
    suspend fun getRelationTypes(): List<RelationType>
    suspend fun getUserRelations(id: Int, page: Int?, limit: Int?): List<UserRelationDto>
}