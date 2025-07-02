package com.cesi.ressourcesrelationnelles.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
    val email: String = "",
    val password: String = ""
)

class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel()
{
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun submitForm() {
        viewModelScope.launch {
            try {
                /* TODO() Ajouter l'appel à l'authentification de l'utilisateur ' */
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Erreur : ${e.message}") }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun updateEmail(email: String) {
        _uiState.update { currentState ->
            currentState.copy(email = email) }
    }
    fun updatePassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy(password = password) }
    }
}