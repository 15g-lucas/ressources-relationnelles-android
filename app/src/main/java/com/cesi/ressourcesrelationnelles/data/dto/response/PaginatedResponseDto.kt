package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class PaginatedResponseDto<T : DataDto>(
    @Json(name ="current_page") val currentPage: Int,
    val data: List<T>,
    val from: Int,
    @Json(name = "last_page") val lastPage: Int,
    @Json(name = "per_page") val perPage: Int,
    val to: Int,
    val total: Int,
    val meta: MetaDto
)