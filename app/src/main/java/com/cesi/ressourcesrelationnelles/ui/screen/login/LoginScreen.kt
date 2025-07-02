package com.cesi.ressourcesrelationnelles.ui.screen.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cesi.ressourcesrelationnelles.ui.component.InputField

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color(0xFFD9D9D9))
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Connexion",
            style = MaterialTheme.typography.headlineMedium
        )
        InputField(
            placeholder = "Saisissez votre email",
            value = uiState.email,
            onValueChange = { viewModel.updateEmail(it) },
            keyboardType = KeyboardType.Email,
            icon = Icons.Default.Email
        )
        InputField(
            placeholder = "Saisissez votre mot de passe",
            value = uiState.password,
            onValueChange = { viewModel.updatePassword(it) },
            keyboardType = KeyboardType.Password,
            icon = Icons.Default.Password
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "S'inscrire",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        TextButton(
            onClick = { },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Déjà inscrit ?",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}