package com.cesi.ressourcesrelationnelles.data.dto

import com.squareup.moshi.Json

@Json
data class SearchDto(
    val text: TextDto = TextDto(""),
    val scopes: List<ScopeDto> = emptyList(),
    val filters: List<FilterDto> = emptyList(),
    val sorts: List<SortDto> = emptyList(),
    val selects: List<SelectDto> = emptyList(),
    val includes: List<IncludeDto> = emptyList(),
    val aggregates: List<AggregateDto> = emptyList(),
    val instructions: List<InstructionDto> = emptyList(),
    val gates: List<String> = emptyList(),
    val page: Int,
    val limit: Int
)
