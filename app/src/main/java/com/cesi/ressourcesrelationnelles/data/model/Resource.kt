package com.cesi.ressourcesrelationnelles.data.model

import com.squareup.moshi.Json

data class Resource (
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val visibility: Int,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
)