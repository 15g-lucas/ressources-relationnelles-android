package com.cesi.ressourcesrelationnelles.ui.screen.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.ui.component.InputField
import com.cesi.ressourcesrelationnelles.ui.screen.login.LoginUiState
import com.cesi.ressourcesrelationnelles.ui.screen.login.LoginViewModel
import com.cesi.ressourcesrelationnelles.ui.screen.register.RegisterViewModel

@Composable
fun LoginForm(
    uiState: LoginUiState,
    viewModel: LoginViewModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        InputField(
            value = uiState.email,
            onValueChange = { viewModel.updateEmail(it) },
            placeholder = "Email",
            icon = Icons.Default.Person
        )

        InputField(
            value = uiState.password,
            onValueChange = { viewModel.updatePassword(it) },
            placeholder = "Mot de passe",
            icon = Icons.Default.Lock
        )
    }
}