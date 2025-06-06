package com.cesi.ressourcesrelationnelles.ui.screen.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.data.model.Relation
import com.cesi.ressourcesrelationnelles.data.model.RelationType
import com.cesi.ressourcesrelationnelles.data.model.RelationUser
import com.cesi.ressourcesrelationnelles.data.model.User

@Composable
fun Relations(
    userByRelation: Map<RelationType, List<RelationUser>>,
    padding: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        userByRelation.forEach { userByRelation ->
            item {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF1B1F23))
                ) {
                    RelationRow(
                        relation = userByRelation.key.typeName,
                        usersByRelation = userByRelation.value
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun RelationsPreview() {
    val relationType = listOf<RelationType>(
        RelationType(
            typeId = 1,
            typeName = "Famille"
        ),
        RelationType(
            typeId = 2,
            typeName = "Collègues"
        ),
        RelationType(
            typeId = 3,
            typeName = "Ami(e)s"
        ),
        RelationType(
            typeId = 4,
            typeName = "Autres"
        )
    )
    val user = listOf<RelationUser>(
        RelationUser(
            id = 4,
            firstName = "Michelle",
            lastName = "Saucisse",
            profilePicture = "toto",
            typeId = 1
        ),
        RelationUser(
            id = 5,
            firstName = "Jean",
            lastName = "Michel",
            profilePicture = "toto",
            typeId = 2
        ),
        RelationUser(
            id = 6,
            firstName = "Bernard",
            lastName = "Malaise",
            profilePicture = "toto",
            typeId = 3
        ),
        RelationUser(
            id = 7,
            firstName = "Laurent",
            lastName = "Didier",
            profilePicture = "toto",
            typeId = 4
        ),
        RelationUser(
            id = 8,
            firstName = "Lulu",
            lastName = "Michel",
            profilePicture = "toto",
            typeId = 1
        ),
        RelationUser(
            id = 9,
            firstName = "Jean",
            lastName = "Michel",
            profilePicture = "toto",
            typeId = 1
        ),
        RelationUser(
            id = 10,
            firstName = "Jean",
            lastName = "Michel",
            profilePicture = "toto",
            typeId = 1
        )
    )
    val usersByRelation = relationType.associateWith { relationType -> user.filter { it.typeId == relationType.typeId } }
    Relations(userByRelation = usersByRelation, padding = PaddingValues(10.dp))
}