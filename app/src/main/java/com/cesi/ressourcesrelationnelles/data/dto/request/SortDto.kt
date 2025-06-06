package com.cesi.ressourcesrelationnelles.data.dto

import com.squareup.moshi.Json

@Json
data class SortDto(
    val field: String,
    val direction: String
)
