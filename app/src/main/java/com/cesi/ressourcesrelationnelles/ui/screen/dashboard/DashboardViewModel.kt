package com.cesi.ressourcesrelationnelles.ui.screen.dashboard

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.data.repository.ResourceRepository
import com.cesi.ressourcesrelationnelles.data.repository.TokenRepository
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

val fakedata = listOf(
    ResourceDto(
        id = 1,
        author = "John Doe",
        title = "Mon premier post",
        description = "Voici mon premier post",
        url = "https://picsum.photos/600",
        visibility = 1,
        createdAt = "2025-04-12",
        updatedAt = "2025-04-12"
    ),
     ResourceDto(
        id = 2,
        author = "Jeanne Doe",
        title = "Mon premier post",
        description = "COUCOU",
        url = "https://picsum.photos/600",
        visibility = 1,
        createdAt = "2025-04-12",
        updatedAt = "2025-04-12"
    ),
    ResourceDto(
        id = 3,
        author = "Johnny Doe",
        title = "Mon premier post",
        description = "Lettttttttttttts go",
        url = "https://picsum.photos/600",
        visibility = 1,
        createdAt = "2025-04-12",
        updatedAt = "2025-04-12"
    ),
)

data class DashboardUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
    val resources: List<ResourceDto> = emptyList(),
    val userDto: UserDto? = null,
    val selectedOptions: MutableList<String> = mutableListOf(),
    val selectedMediaUri: MutableState<Uri?> = mutableStateOf(null)
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val userRepository: UserRepository,
    private val resourceRepository: ResourceRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(resources = fakedata) }
    }

    fun fetchResources() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val resources = resourceRepository.getUserResources(
                    id = 1, /* TODO add userId */
                    page = 1,
                    limit = 10
                )
                _uiState.update { it.copy(resources = resources) }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = e.message) }
            }
        }
    }

    fun publishPost(
        selectedOptions: List<String> = uiState.value.selectedOptions,
        selectedMediaUri: Uri? = uiState.value.selectedMediaUri.value
    ) {
        viewModelScope.launch {
//            resourceRepository.createResource()
        }
    }
}