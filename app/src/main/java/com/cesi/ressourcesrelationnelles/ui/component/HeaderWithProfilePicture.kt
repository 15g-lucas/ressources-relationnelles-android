package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun HeaderWithProfilePicture(
    profilePictureUrl: String,
    title: String,
    backButton: Boolean = true,
    onBackClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (backButton) {
            IconButton(
                onClick = { onBackClick() }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        }
        Text(title, style = MaterialTheme.typography.titleLarge)
        AsyncImage(
            model = profilePictureUrl,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(33.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.onBackground, CircleShape)
        )

    }
}

@Preview
@Composable
fun HeaderWithProfilePicturePreview() {
    HeaderWithProfilePicture(
        profilePictureUrl = "https://unsplash.com/fr/photos/un-petit-oiseau-perche-sur-la-main-dune-personne-9yYpMvn-j30",
        title = "Titre de l'écran"
    )
}