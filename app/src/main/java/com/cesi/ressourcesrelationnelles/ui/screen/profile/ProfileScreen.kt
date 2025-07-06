package com.cesi.ressourcesrelationnelles.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.cesi.ressourcesrelationnelles.di.LocalMainViewModel
import com.cesi.ressourcesrelationnelles.ui.component.NavBar
import com.cesi.ressourcesrelationnelles.ui.component.PostList
import com.cesi.ressourcesrelationnelles.ui.component.ProfileHeader
import com.cesi.ressourcesrelationnelles.ui.screen.profile.components.Relations
import com.cesi.ressourcesrelationnelles.ui.theme.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavController
) {

    val mainViewModel = LocalMainViewModel.current
    val user by mainViewModel.user.collectAsStateWithLifecycle()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }

                    ) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Nav back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavBar(
                navController = navController,
            )
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
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            ProfileHeader(
                profilePictureUrl = user?.profilePicture ?: "",
                name = "${user?.firstName} ${user?.lastName}",
                bio = "",
                onProfilePictureSelected = { }
            )
            Row(
                modifier = Modifier
                    .width(230.dp)
                    .height(32.dp)
                    .background(color = Color(0xFFFBC02D), shape = RoundedCornerShape(size = 10.dp))
                    .clip(RoundedCornerShape(size = 10.dp))
                    .clickable(onClick = { /* Handle edit button click */ })
                    .padding(start = 41.dp, end = 41.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edition",
                    Modifier
                        .padding(0.dp)
                        .width(17.dp)
                        .height(17.dp),
                    tint = Color(0xFFFFFFFF)
                )
                Text(
                    text = "Modifier le profil",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )

            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SingleChoiceSegmentedButtonRow(
                    Modifier
                        .width(294.dp)
                        .height(48.dp)
                ) {
                    uiState.options.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = uiState.options.size
                            ),
                            onClick = { viewModel.updateSelectedIndex(index) },
                            selected = uiState.selectedIndex == index,
                            enabled = true,
                        ) {
                            Text(label)
                        }
                    }
                }
            }
            when (uiState.selectedIndex) {
                0 -> Relations(uiState.usersByRelation, padding = padding, navController =  navController)
                1 -> PostList(uiState.resources, padding)
            }
        }
    }
}
