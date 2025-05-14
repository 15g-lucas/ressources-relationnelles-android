package com.cesi.ressourcesrelationnelles.ui.screen.profile.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun RelationHeader(
    relationType: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = relationType)
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Voir tous")
        }
    }
}