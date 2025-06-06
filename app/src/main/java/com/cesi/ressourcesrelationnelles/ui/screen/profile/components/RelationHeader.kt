package com.cesi.ressourcesrelationnelles.ui.screen.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RelationHeader(
    relationType: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = relationType
        )
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Voir tous")
        }
    }
}

@Preview
@Composable
fun RelationHeaderPreview()
{
    RelationHeader(relationType = "Famille")
}