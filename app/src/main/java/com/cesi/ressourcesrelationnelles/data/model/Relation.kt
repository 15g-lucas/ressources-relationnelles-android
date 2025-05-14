package com.cesi.ressourcesrelationnelles.data.model

import com.squareup.moshi.Json

data class Relation (
    val type: Int,
    val state: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
)