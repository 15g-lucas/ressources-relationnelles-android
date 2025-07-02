package com.cesi.ressourcesrelationnelles.ui.screen.login

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cesi.ressourcesrelationnelles.ui.screen.login.components.LoginForm
import com.cesi.ressourcesrelationnelles.ui.theme.roboto

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
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
                onClick = {
                    viewModel.submitForm()

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color(0xFFFCFCFC)
                )
            ) {
                Text(
                    text = "Suivant",
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
                onClick = { }
            ) {
                Text(text = "Pas de compte ? ", color = Color(0xFF252525))
                Text("Inscris-toi", fontWeight = FontWeight.Bold)
            }
        }
    }
}
