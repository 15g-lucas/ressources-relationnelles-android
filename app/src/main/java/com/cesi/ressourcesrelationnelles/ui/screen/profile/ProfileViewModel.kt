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
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
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
    var uiState = ProfileUiState()
        private set

    fun updateSelectedIndex(index: Int) {
        uiState = uiState.copy(selectedIndex = index)
    }

    private fun loadProfile(id: Int) {
        uiState = uiState.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val user = userRepository.getUsersById(id)
                val userRelations =
                    relationRepository.getUserRelations(id = id, page = 1, limit = 10)
                val resources =
                    resourceRepository.getUserResources(id = id, page = 1, limit = 10)
                val relationType = relationRepository.getRelationTypes()
                uiState = uiState.copy(
                    isLoading = false,
                    user = user,
                    relationType = relationType,
                    userRelations = userRelations,
                    resources = resources,
                    usersByRelation = relationType.associateWith { relationType ->
                        userRelations.filter { it.typeId == relationType.typeId }
                    }
                )
            } catch (e: Exception) {
                uiState = uiState.copy(isLoading = false, error = e.message)
            }
        }
    }


}