package com.cesi.ressourcesrelationnelles.data.dto.request

import com.squareup.moshi.Json

@Json
data class InstructionFieldDto(
    val name: String,
    val value: String
)
