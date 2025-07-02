package com.cesi.ressourcesrelationnelles.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.model.Resource
import com.cesi.ressourcesrelationnelles.ui.component.PostList
import com.cesi.ressourcesrelationnelles.ui.component.ProfileHeader
import com.cesi.ressourcesrelationnelles.ui.screen.home.components.HeaderWithProfilePicture

data class HomeUiState(
    val isLoading: Boolean = false,
    val resources: List<ResourceDto>
)
@Composable
fun HomeScreen() {
    val uiState = HomeUiState(
        isLoading = false,
        resources = emptyList()
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderWithProfilePicture(
            profilePictureUrl = "",
            title = "Fil d'actualités"
        )
        PostList(
            resources = uiState.resources,
            padding = PaddingValues(0.dp)
        )
    }
}