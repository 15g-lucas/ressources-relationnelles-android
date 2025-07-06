package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

data class TokenDto(
    @Json(name = "access_token") val accessToken : String,
    @Json(name = "token_type") val tokenType : String,
)