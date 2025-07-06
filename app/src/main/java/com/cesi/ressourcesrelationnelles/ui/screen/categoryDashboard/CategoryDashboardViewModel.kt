package com.cesi.ressourcesrelationnelles.ui.screen.categoryDashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.repository.ResourceRepository
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
        title = "La place de jaude, capital de la mode",
        description = "Voici mon premier post",
        url = "https://picsum.photos/600",
        visibility = 1,
        createdAt = "2025-04-12",
        updatedAt = "2025-04-12"
    ),
    ResourceDto(
        id = 2,
        author = "Jeanne Doe",
        title = "Le puy de sancy",
        description = "COUCOU",
        url = "https://picsum.photos/600",
        visibility = 1,
        createdAt = "2025-04-12",
        updatedAt = "2025-04-12"
    ),
    ResourceDto(
        id = 3,
        author = "Johnny Doe",
        title = "L'Auvergne c'est top",
        description = "Je monte le Puy de dôme !!!",
        url = "https://picsum.photos/600",
        visibility = 1,
        createdAt = "2025-04-12",
        updatedAt = "2025-04-12"
    ),
)


data class CategoryDashboardUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val resources: List<ResourceDto> = emptyList()
)

@HiltViewModel
class CategoryDashboardViewModel @Inject constructor(
    private val categoryRepository: ResourceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoryDashboardUiState())
    val uiState: StateFlow<CategoryDashboardUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(resources = fakedata) }
        //fetchResources()
    }

    fun fetchResources(categoryId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            try {
                val resources = categoryRepository.getResourcesByCategory(categoryId)
                _uiState.value = _uiState.value.copy(resources = resources, isLoading = false)
            } catch (
                e: Exception
            ) {
                _uiState.value = _uiState.value.copy(error = e.message, isLoading = false)
            } finally {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }

        }
    }
}