package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class ResourceDto(
    override val id: Int,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val visibility: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
) : DataDto
