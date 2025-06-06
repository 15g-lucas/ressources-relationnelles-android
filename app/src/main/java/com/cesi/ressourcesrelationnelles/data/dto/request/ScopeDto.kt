package com.cesi.ressourcesrelationnelles.data.dto

import com.squareup.moshi.Json

@Json
data class ScopeDto(
    val name: String,
    val parameters: List<Boolean>
)
