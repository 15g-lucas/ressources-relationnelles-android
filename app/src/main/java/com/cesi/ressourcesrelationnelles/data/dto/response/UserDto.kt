package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class UserDto (
    val id: Int,
    val username: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    @Json(name = "date_of_birth") val dateOfBirth: String,
    @Json(name = "profile_picture") val profilePicture: String,
    val phone: String,
    val address: String,
    val city: String,
    val country: String,
    @Json(name = "zip_code") val zipcode: String,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
    val role: Int,
    @Json(name = "is_active") val isActive: Boolean,
    @Json(name = "last_login") val lastLogin: String,
    override val gates: List<GateDto?>
): DataDto