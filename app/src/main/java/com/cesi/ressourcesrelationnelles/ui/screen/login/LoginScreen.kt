package com.cesi.ressourcesrelationnelles.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.cesi.ressourcesrelationnelles.di.LocalMainViewModel
import com.cesi.ressourcesrelationnelles.navigation.NavRoutes
import com.cesi.ressourcesrelationnelles.ui.screen.login.components.LoginForm
import com.cesi.ressourcesrelationnelles.ui.theme.roboto

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    val mainViewModel = LocalMainViewModel.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.ShowSnackbar -> {
//                    snackbarHostState.showSnackbar(event.message)
                }
                UiEvent.NavigateToDashboard -> {
                    mainViewModel.loadUser()
                    navController.navigate("dashboard") {
                        popUpTo(NavRoutes.Login.route) { inclusive = true }
                    }
                }
            }
        }
    }


    Scaffold(
        topBar = {

        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LoginForm(
                uiState = uiState,
                viewModel = viewModel,
                modifier = Modifier.align(Alignment.Center)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
                    .navigationBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 30.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { viewModel.submitForm() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color(0xFFFCFCFC)
                    ),
                    enabled = !uiState.isLoading
                ) {
                    Text(
                        text = if (uiState.isLoading) "Connexion..." else "Suivant",
                        fontSize = 20.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(Modifier.height(25.dp))

                TextButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 30.dp, vertical = 5.dp),
                    onClick = { navController.navigate(NavRoutes.Register.route) },
                    enabled = !uiState.isLoading
                ) {
                    Text(text = "Pas de compte ? ", color = Color(0xFF252525))
                    Text("Inscris-toi", fontWeight = FontWeight.Bold)
                }
            }

            if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0x88000000)) // semi-transparent
                        .align(Alignment.Center)
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

    }
}
