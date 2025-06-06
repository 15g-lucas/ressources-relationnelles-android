package com.cesi.ressourcesrelationnelles.data.dto

import com.squareup.moshi.Json

@Json
data class InstructionFieldDto(
    val name: String,
    val value: String
)
