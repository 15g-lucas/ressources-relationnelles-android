package com.cesi.ressourcesrelationnelles.data.dto.request

import com.squareup.moshi.Json

@Json
data class AggregateDto (
    val relation: String,
    val type: String,
    val field: String,
    val alias: String,
    val filters: List<FilterDto>
)