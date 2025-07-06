package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class DataRelationUserDto(
    override val id: Int,
    val firstName: String,
    val lastName: String,
    val typeId: Int,
    val profilePicture: String,
//    override val gates: List<GateDto?>,
) : DataDto
