package com.cesi.ressourcesrelationnelles.ui.screen.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto

@Composable
fun RelationRow(relation: String, usersByRelation: List<UserRelationDto>,
                 onSeeAllClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        RelationHeader(relationType = relation,
            onSeeAllClick = { onSeeAllClick() })
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            usersByRelation.forEach { user ->
                item {
                    RelationCard(user = user)
                }
            }
        }

    }
}

@Preview
@Composable
fun RelationRowPreview() {
    val user = listOf(
        UserRelationDto(
            id = 1,
            firstName = "Michelle",
            lastName = "Saucisse",
            typeId = 1,
            profilePicture = "toto"
        ),
        UserRelationDto(
            id = 2,
            firstName = "Michelle",
            lastName = "Saucisse",
            typeId = 1,
            profilePicture = "toto"
        ),
        UserRelationDto(
            id = 3,
            firstName = "Michelle",
            lastName = "Saucisse",
            typeId = 1,
            profilePicture = "toto"
        )
    )
    RelationRow("Famille", usersByRelation = user)
}

