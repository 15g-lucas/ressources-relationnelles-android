package com.cesi.ressourcesrelationnelles.data.dto.request

import com.squareup.moshi.Json

@Json
data class SortDto(
    val field: String,
    val direction: String
)
