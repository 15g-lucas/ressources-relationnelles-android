package com.cesi.ressourcesrelationnelles.ui.screen.login

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.datastore.PreferencesKeys
import com.cesi.ressourcesrelationnelles.data.repository.TokenRepository
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
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

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
    object NavigateToDashboard : UiEvent()

}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository,
    private val tokenRepository: TokenRepository
) : ViewModel()
{
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun submitForm() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val token = repository.login(
                    email = _uiState.value.email,
                    password = _uiState.value.password
                )
                tokenRepository.saveToken(token.accessToken)
                _uiEvent.emit(UiEvent.ShowSnackbar("Connexion réussie"))
                _uiEvent.emit(UiEvent.NavigateToDashboard)
            } catch (e: Exception) {
                _uiEvent.emit(UiEvent.ShowSnackbar("Erreur : ${e.message}"))
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