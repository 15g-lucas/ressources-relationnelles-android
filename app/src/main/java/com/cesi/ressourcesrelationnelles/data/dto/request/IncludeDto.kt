package com.cesi.ressourcesrelationnelles.data.dto.request

import com.squareup.moshi.Json

@Json
data class IncludeDto(
    val relation: String,
    val filters: List<FilterDto>,
    val limit: Int? = null
)
