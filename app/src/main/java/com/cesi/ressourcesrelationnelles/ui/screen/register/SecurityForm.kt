package com.cesi.ressourcesrelationnelles.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.ui.component.InputField

@Composable
fun SecurityForm(
    uiState : RegisterUiState,
    viewModel: RegisterViewModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        InputField(
            value = uiState.username,
            onValueChange = { viewModel.updateUsername(it) },
            placeholder = "Nom d'utilisateur",
            icon = Icons.Default.Person
        )
        InputField(
            value = uiState.email,
            onValueChange = { viewModel.updateEmail(it) },
            placeholder = "Email",
            icon = Icons.Default.Email
        )
        InputField(
            value = uiState.password,
            onValueChange = { viewModel.updatePassword(it) },
            placeholder = "Mot de passe",
            icon = Icons.Default.Password
        )
        InputField(
            value = uiState.confirmPassword,
            onValueChange = { viewModel.updateConfirmPassword(it) },
            placeholder = "Confirmation mot de passe",
            icon = Icons.Default.Password
        )
    }

}