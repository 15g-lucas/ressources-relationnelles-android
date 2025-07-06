package com.cesi.ressourcesrelationnelles.ui.screen.dashboard

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.ui.component.NavBar
import com.cesi.ressourcesrelationnelles.ui.component.PostList
import com.cesi.ressourcesrelationnelles.MainViewModel
import com.cesi.ressourcesrelationnelles.di.LocalMainViewModel
import com.cesi.ressourcesrelationnelles.ui.screen.createpost.CreatePost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    navController: NavController
) {
    val mainViewModel = LocalMainViewModel.current
    val user by mainViewModel.user.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showAddPost by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Fil d'actualités") },
                actions = {
                    AsyncImage(
                        model = user?.profilePicture,
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .size(33.dp)
                            .clip(CircleShape)
                            .border(1.dp, MaterialTheme.colorScheme.onBackground, CircleShape)
                    )
                }
            )
        },
        bottomBar = { NavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddPost = true }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            PostList(
                resources = uiState.resources,
                padding = PaddingValues(0.dp)
            )

        }
        AnimatedVisibility(
            visible = showAddPost,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight },
                animationSpec = tween(durationMillis = 400)
            ),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight },
                animationSpec = tween(durationMillis = 400)
            )
        ) {
            CreatePost(
                selectedOptions = remember { uiState.selectedOptions },
                selectedMediaUri = uiState.selectedMediaUri,
                onDismiss = { showAddPost = false },
                onPublishClick = {
                    showAddPost = false
                    viewModel.publishPost()
                },
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}