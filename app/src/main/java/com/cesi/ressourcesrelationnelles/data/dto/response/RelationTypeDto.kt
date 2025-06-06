package com.cesi.ressourcesrelationnelles.data.dto.response

data class RelationTypeDto(
    val typeId: Int,
    val typeName: String,
    override val gates: List<GateDto?>
) : DataDto
