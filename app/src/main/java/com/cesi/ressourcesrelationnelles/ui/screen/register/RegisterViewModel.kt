package com.cesi.ressourcesrelationnelles.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.request.CreateUserDto
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RegisterUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
    val step: Int = 1,
    val username: String = "",
    val firstname: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel()
{
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun submitForm() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            try {
                userRepository.register(
                    CreateUserDto(
                        username = _uiState.value.username,
                        firstname = _uiState.value.firstname,
                        lastname = _uiState.value.lastname,
                        email = _uiState.value.email,
                        password = _uiState.value.password
                    )
                )
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "Erreur : ${e.message}") }

            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }

        }
    }

    fun updateUsername(username: String) {
        _uiState.update { currentState ->
            currentState.copy(username = username)
        }
    }

    fun updateFirstname(firstname: String) {
        _uiState.update { currentState ->
            currentState.copy(firstname = firstname)
        }
    }

    fun updateLastname(lastname: String) {
        _uiState.update { currentState ->
            currentState.copy(lastname = lastname)
        }
    }

    fun updateEmail(email: String) {
        _uiState.update { currentState ->
            currentState.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun updateConfirmPassword(confirmPassword: String) {
        _uiState.update { currentState ->
            currentState.copy(confirmPassword = confirmPassword)
        }
    }

    fun updateStep(step: Int) {
        _uiState.update { currentState ->
            currentState.copy(step = step)
        }
    }
}