package com.cesi.ressourcesrelationnelles.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.response.ResourceDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import com.cesi.ressourcesrelationnelles.data.model.RelationType
import com.cesi.ressourcesrelationnelles.data.repository.RelationRepository
import com.cesi.ressourcesrelationnelles.data.repository.ResourceRepository
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import com.cesi.ressourcesrelationnelles.ui.screen.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ProfileUiState(
    val isLoading: Boolean = false,
    val user: UserDto? = null,
    val relationType: List<RelationType>? = emptyList(),
    val userRelations: List<UserRelationDto>? = emptyList(),
    val usersByRelation: Map<RelationType, List<UserRelationDto>> = emptyMap(),
    val resources: List<ResourceDto> = emptyList(),
    val error: String? = null,
    val selectedIndex: Int = 0,
    val options: List<String> = listOf("Relations", "Posts")
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val relationRepository: RelationRepository,
    private val resourceRepository: ResourceRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun updateSelectedIndex(index: Int) {
        _uiState.update { currentState ->
            currentState.copy(selectedIndex = index)
        }
    }

    private fun loadProfile(id: Int) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val user = userRepository.getUsersById(id)
                val userRelations =
                    relationRepository.getUserRelations(id = id, page = 1, limit = 10)
                val resources =
                    resourceRepository.getUserResources(id = id, page = 1, limit = 10)
                val relationType = relationRepository.getRelationTypes()
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        user = user,
                        relationType = relationType,
                        userRelations = userRelations,
                        resources = resources,
                        usersByRelation = relationType.associateWith { relationType ->
                            userRelations.filter { it.typeId == relationType.typeId }
                        }
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}