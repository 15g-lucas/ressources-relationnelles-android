package com.cesi.ressourcesrelationnelles.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.ui.screen.profile.components.EditProfilePicture

@Composable
fun ProfileHeader(
    profilePictureUrl: String,
    name: String,
    bio: String? = null,
    onProfilePictureSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        EditProfilePicture(
            profilePictureUrl = profilePictureUrl,
            onProfilePictureSelected = { onProfilePictureSelected }
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge

            )
            Text(
                text = bio ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    ProfileHeader(
        profilePictureUrl = "",
        name = "John Doe",
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        onProfilePictureSelected = { }
    )
}