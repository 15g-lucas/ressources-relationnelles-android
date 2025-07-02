package com.cesi.ressourcesrelationnelles.ui.screen.profile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun EditProfilePicture(
    profilePictureUrl: String,
    onProfilePictureSelected: () -> Unit
) {
    Box(
        modifier = Modifier.size(90.dp)
            .clickable(
                onClick = { onProfilePictureSelected }
            ),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = profilePictureUrl,
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        )
        Box(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.BottomEnd)
                .clip(CircleShape)
                .background(Color(0xFFB0BEC5))
                .border(BorderStroke(1.dp, MaterialTheme.colorScheme.background), CircleShape)
        ) {
            Icon(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Center)
                    .size(12.dp),
                imageVector = Icons.Default.PhotoCamera,
                contentDescription = "Edit profile",
            )
        }
    }

}