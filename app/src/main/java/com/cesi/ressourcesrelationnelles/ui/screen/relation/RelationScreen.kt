package com.cesi.ressourcesrelationnelles.ui.screen.relation

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import com.cesi.ressourcesrelationnelles.ui.screen.profile.components.RelationCard
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.cesi.ressourcesrelationnelles.di.LocalMainViewModel

@Composable
fun RelationScreen(
    viewModel: RelationViewModel = hiltViewModel(),
    navController: NavController,
    relationTypeId: Int
) {
    val mainViewModel = LocalMainViewModel.current
    val user by mainViewModel.user.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchUser(user!!.id, relationTypeId)
    }


    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(3)
    ) {
        uiState.users.forEach { user ->
            item {
                RelationCard(user)
            }
        }
    }
}