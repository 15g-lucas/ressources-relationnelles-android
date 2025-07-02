package com.cesi.ressourcesrelationnelles.ui.screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cesi.ressourcesrelationnelles.R
import com.cesi.ressourcesrelationnelles.ui.screen.register.components.PersonalForm
import com.cesi.ressourcesrelationnelles.ui.screen.register.components.SecurityForm
import com.cesi.ressourcesrelationnelles.ui.theme.roboto

@Composable
fun RegisterScreen(viewModel: RegisterViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {

            val visible = uiState.step == 2

            IconButton(
                modifier = Modifier
                    .padding(16.dp)
                    .alpha(if (visible) 1f else 0f),
                onClick = { viewModel.updateStep(1) }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Retour"
                )
            }

            Image(
                painter = painterResource(R.drawable.group_36),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            )
        }

        when (uiState.step) {
            1 -> PersonalForm(uiState, viewModel, Modifier.align(Alignment.Center))
            2 -> SecurityForm(uiState, viewModel, Modifier.align(Alignment.Center))
        }
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
                    if (uiState.step == 1) {
                        viewModel.updateStep(2)
                    } else {
                        viewModel.submitForm()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color(0xFFFCFCFC)
                )
            ) {
                if (uiState.step == 1) {
                    Text(
                        text = "Suivant",
                        fontSize = 20.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(Modifier.width(5.dp))
                    Icon(
                        Icons.AutoMirrored.Rounded.ArrowForwardIos,
                        contentDescription = "Suivant", Modifier.size(20.dp)
                    )
                } else {
                    Text(text = "Valider", fontSize = 20.sp)
                }
            }
            Spacer(Modifier.height(25.dp))
            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 30.dp, vertical = 5.dp),
                onClick = { }
            ) {
                Text(text = "Déjà membre ? ", color = Color(0xFF252525))
                Text("Connecte-toi", fontWeight = FontWeight.Bold)
            }
        }
    }
}


