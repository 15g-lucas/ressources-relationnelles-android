package com.cesi.ressourcesrelationnelles.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    override val id: Int,
    val title: String,
) : DataDto