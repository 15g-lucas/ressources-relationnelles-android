package com.cesi.ressourcesrelationnelles.ui.screen.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.response.CategoryDto
import com.cesi.ressourcesrelationnelles.data.repository.ResourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

val fakedata = listOf(
    CategoryDto(1, "Bien être"),
    CategoryDto(2, "Voyage"),
    CategoryDto(3, "Cuisine"),
    CategoryDto(4, "Sport"),
    CategoryDto(5, "Jeux"),
    CategoryDto(6, "Art"),
    CategoryDto(7, "Cinéma"),
    CategoryDto(8, "Musique"),
    CategoryDto(9, "Jeux vidéo")
)


data class CategoryUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
    val categories: List<CategoryDto> = emptyList()
)

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: ResourceRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(CategoryUiState())
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()


    init {
        _uiState.update { it.copy(categories = fakedata) }
        fetchCategories()
    }

    private fun fetchCategories()
    {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val categories = repository.getCategories()
                _uiState.update { it.copy(categories = categories) }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = e.message) }
            }
        }
    }
}