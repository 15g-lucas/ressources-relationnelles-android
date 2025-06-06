package com.cesi.ressourcesrelationnelles.data.dto.request

import com.squareup.moshi.Json

@Json
data class InstructionDto(
    val name: String,
    val fields: List<InstructionFieldDto>
)
