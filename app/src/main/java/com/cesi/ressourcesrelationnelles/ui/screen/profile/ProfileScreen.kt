package com.cesi.ressourcesrelationnelles.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.ui.component.PostList
import com.cesi.ressourcesrelationnelles.ui.screen.profile.components.Relations

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
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
                0 -> Relations(uiState.usersByRelation, padding)
                1 -> PostList(uiState.resources, padding)
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenTest(
//    viewModel: ProfileViewModel = hiltViewModel(),
//    navController: NavController
) {
    val uiState = ProfileUiState(
        isLoading = false,
        user = UserDto(
            id = 1,
            username = "test",
            email = "test",
            password = "test",
            firstName = "test",
            lastName = "test",
            dateOfBirth = "12/05/1999",
            profilePicture = "test",
            phone = "test",
            address = "test",
            city = "test",
            country = "test",
            zipcode = "test",
            createdAt = "test",
            updatedAt = "test",
            role = 1,
            isActive = true,
            lastLogin = "test",
            gates = emptyList()
        ),
        relationType = emptyList(),
        userRelations = emptyList(),
        usersByRelation = emptyMap(),
        resources = emptyList(),
        error = null,
        selectedIndex = 0,
        options = listOf("Relations", "Posts")
    )
    Scaffold(
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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            SingleChoiceSegmentedButtonRow {
                uiState.options.forEachIndexed { index, label ->
                    SegmentedButton(
                        shape = RoundedCornerShape(32.dp),
                        onClick = { },
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
                0 -> Relations(uiState.usersByRelation, padding)
                1 -> PostList(uiState.resources, padding)
            }
        }
    }
}
