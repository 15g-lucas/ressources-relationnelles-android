package com.cesi.ressourcesrelationnelles.ui.screen.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cesi.ressourcesrelationnelles.ui.component.InputField
import com.cesi.ressourcesrelationnelles.ui.screen.register.RegisterUiState
import com.cesi.ressourcesrelationnelles.ui.screen.register.RegisterViewModel

@Composable
fun PersonalForm(
    uiState: RegisterUiState,
    viewModel: RegisterViewModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ) {
        InputField(
            value = uiState.firstname,
            onValueChange = { viewModel.updateFirstname(it) },
            placeholder = "Prénom",
            icon = Icons.Default.Person
        )

        InputField(
            value = uiState.lastname,
            onValueChange = { viewModel.updateLastname(it) },
            placeholder = "Nom de famille",
            icon = Icons.Default.Person
        )
    }
}