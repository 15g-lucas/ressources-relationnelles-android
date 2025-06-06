package com.cesi.ressourcesrelationnelles.data.dto.response

import com.squareup.moshi.Json

@Json
data class GateDto(
    @Json(name = "authorized_to_create") val authorizedToCreate: Boolean?,
    @Json(name = "authorized_to_view") val authorizedToView: Boolean?,
    @Json(name = "authorized_to_update") val authorizedToUpdate: Boolean?,
    @Json(name = "authorized_to_delete") val authorizedToDelete: Boolean?,
    @Json(name = "authorized_to_restore") val authorizedToRestore: Boolean?,
    @Json(name = "authorized_to_force_update") val authorizedToForceUpdate: Boolean?
)
