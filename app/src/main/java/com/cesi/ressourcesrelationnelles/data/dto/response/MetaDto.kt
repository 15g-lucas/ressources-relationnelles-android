package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class MetaDto(
    val gates: List<GateDto?>
)
