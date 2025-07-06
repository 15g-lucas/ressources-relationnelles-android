package com.cesi.ressourcesrelationnelles.ui.screen.categoryDashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.di.LocalMainViewModel
import com.cesi.ressourcesrelationnelles.ui.component.NavBar
import com.cesi.ressourcesrelationnelles.ui.component.PostList

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun CategoryDashboardScreen(
    viewModel: CategoryDashboardViewModel = hiltViewModel(),
    navController: NavController,
    categoryId: Int,
    categoryTitle: String
) {
    val mainViewModel = LocalMainViewModel.current
    val userDto by mainViewModel.user.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(categoryTitle) },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Nav back"
                        )
                    }
                },
                actions = {
                    AsyncImage(
                        model = userDto?.profilePicture,
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .size(33.dp)
                            .clip(CircleShape)
                            .border(1.dp, MaterialTheme.colorScheme.onBackground, CircleShape)
                    )
                }
            )
        },
        bottomBar = { NavBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            PostList(
                resources = uiState.resources,
                padding = PaddingValues(0.dp)
            )

        }
    }
}