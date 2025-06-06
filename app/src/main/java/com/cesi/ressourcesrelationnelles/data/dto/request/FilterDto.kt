package com.cesi.ressourcesrelationnelles.data.dto.request

import com.squareup.moshi.Json

@Json
data class FilterDto(
    val field: String? = null,
    val operator: String? = null,
    val value: Any? = null,
    val type: String? = null,
    val nested: List<FilterDto>? = null
)
