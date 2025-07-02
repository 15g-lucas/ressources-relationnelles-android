package com.cesi.ressourcesrelationnelles.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun HeaderWithProfilePicture(
    profilePictureUrl: String,
    title: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title, style = MaterialTheme.typography.titleLarge)
        AsyncImage(
            model = profilePictureUrl,
            contentDescription = "Profile picture",
            modifier = Modifier.size(33.dp)
        )
    }
}

@Preview
@Composable
fun HeaderWithProfilePicturePreview() {
    HeaderWithProfilePicture(
        profilePictureUrl = "https://example.com/profile_picture.jpg",
        title = "Titre de l'écran"
    )
}