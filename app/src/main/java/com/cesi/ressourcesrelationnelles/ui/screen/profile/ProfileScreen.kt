package com.cesi.ressourcesrelationnelles.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.cesi.ressourcesrelationnelles.ui.screen.profile.components.PostList
import com.cesi.ressourcesrelationnelles.ui.screen.profile.components.Relations

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavController
)
{
    val uiState = viewModel.uiState
    Scaffold (
        topBar = {
        },
        bottomBar = {
        }
    ) { padding ->
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        SingleChoiceSegmentedButtonRow {
            uiState.options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = RoundedCornerShape(32.dp),
                    onClick = { viewModel.updateSelectedIndex(index) },
                    selected = uiState.selectedIndex == index,
                    label = { Text(label) },
                    icon = {},
                    modifier = Modifier
                        .width(120.dp)
                        .weight(1f),
                    border = BorderStroke(0.dp, Color.Transparent),
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = Color.White,
                        inactiveContainerColor = Color.Transparent
                    )
                )
            }
        }
        when (uiState.selectedIndex) {
            0 -> Relations(uiState.relationType, padding)
            1 -> PostList(uiState.resources, padding)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {

}