package com.cesi.ressourcesrelationnelles.data.model

data class RelationUser(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val typeId: Int,
    val profilePicture: String
)