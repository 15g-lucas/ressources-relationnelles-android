package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class ResourceDto(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val visibility: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    override val gates: List<GateDto?>,
): DataDto
