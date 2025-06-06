package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class UserRelationDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val typeId: Int,
    val profilePicture: String,
    override val gates: List<GateDto?>
): DataDto