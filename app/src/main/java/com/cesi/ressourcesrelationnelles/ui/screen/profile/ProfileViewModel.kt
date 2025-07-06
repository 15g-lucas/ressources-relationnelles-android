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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.listOf

data class ProfileUiState(
    val isLoading: Boolean = false,
    val relationType: List<RelationType>? = emptyList(),
    val userRelations: List<UserRelationDto>? = emptyList(),
    val usersByRelation: Map<RelationType, List<UserRelationDto>> = emptyMap(),
    val resources: List<ResourceDto> = emptyList(),
    val error: String? = null,
    val selectedIndex: Int = 0,
    val options: List<String> = listOf("Relations", "Posts")
)

val fakedata = ProfileUiState(
    isLoading = false,
    relationType = listOf(
        RelationType(
            typeId = 1,
            typeName = "Amis"
        ),
        RelationType(
            typeId = 2,
            typeName = "Collègues"
        ),
        RelationType(
            typeId = 3,
            typeName = "Famille"
        ),
        RelationType(
            typeId = 4,
            typeName = "Autres"
        )
    ),
    userRelations = listOf(
        UserRelationDto(
            id = 1,
            firstName = "Michel",
            lastName = "Saucisse",
            typeId = 1,
            profilePicture = "https://picsum.photos/100"
        ),
        UserRelationDto(
            id = 2,
            firstName = "Jean",
            lastName = "Michel",
            typeId = 2,
            profilePicture = "https://picsum.photos/100"
        )
    ),
    usersByRelation = mapOf(
        RelationType(
            typeId = 1,
            typeName = "Amis",
            ) to listOf(
            UserRelationDto(
                id = 1,
                firstName = "Michel",
                lastName = "Saucisse",
                typeId = 1,
                profilePicture = "https://picsum.photos/100"
            ),UserRelationDto(
                id = 2,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 2,
                profilePicture = "https://picsum.photos/100"
            ),UserRelationDto(
                id = 2,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 2,
                profilePicture = "https://picsum.photos/100"
            ),UserRelationDto(
                id = 2,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 2,
                profilePicture = "https://picsum.photos/100"
            ),UserRelationDto(
                id = 2,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 2,
                profilePicture = "https://picsum.photos/100"
            )
        ),
        RelationType(
            typeId = 2,
            typeName = "Collègues"
        ) to listOf(
            UserRelationDto(
                id = 4,
                firstName = "Michelle",
                lastName = "Saucisse",
                typeId = 1,
                profilePicture = "https://picsum.photos/100"
            ),
            UserRelationDto(
                id = 5,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 2,
                profilePicture = "https://picsum.photos/100"

            ),
            UserRelationDto(
                id = 6,
                firstName = "Bernard",
                lastName = "Malaise",
                typeId = 3,
                profilePicture = "https://picsum.photos/100"

            ),
            UserRelationDto(
                id = 7,
                firstName = "Laurent",
                lastName = "Didier",
                typeId = 4,
                profilePicture = "https://picsum.photos/100" 

            ),
            UserRelationDto(
                id = 8,
                firstName = "Lulu",
                lastName = "Michel",
                typeId = 1,
                profilePicture = "https://picsum.photos/100" 

            ),
            UserRelationDto(
                id = 9,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 1,
                profilePicture = "https://picsum.photos/100" 

            ),
            UserRelationDto(
                id = 10,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 1,
                profilePicture = "https://picsum.photos/100" 

            )
        ),
        RelationType(
            typeId = 3,
            typeName = "Famille"
        ) to listOf(
            UserRelationDto(
                id = 11,
                firstName = "Michelle",
                lastName = "Saucisse",
                typeId = 1,
                profilePicture = "https://picsum.photos/100" 
            ),
            UserRelationDto(
                id = 12,
                firstName = "Jean",
                lastName = "Michel",
                typeId = 2,
                profilePicture = "https://picsum.photos/100" 
            ),
            UserRelationDto(
                id = 13,
                firstName = "Bernard",
                lastName = "Malaise",
                typeId = 3,
                profilePicture = "https://picsum.photos/100" 
            )
        )
    ),
    resources = listOf(
        ResourceDto(
            id = 1,
            title = "Mon premier post",
            description = "Voici mon premier post",
            author = "John Doe",
            url = "https://picsum.photos/600",
            createdAt = "<18h>",
            updatedAt = "19h",
            visibility = 1,
        ),
        ResourceDto(
            id = 2,
            title = "SUPER LA VIE",
            description = "",
            author = "John Doe",
            url = "https://picsum.photos/600",
            createdAt = "11h",
            updatedAt = "12h",
            visibility = 1,
        ),
        ResourceDto(
            id = 3,
            title = "C'est pas faux",
            description = "",
            author = "John Doe",
            url = "https://picsum.photos/600",
            createdAt = "13h",
            updatedAt = "14h",
            visibility = 1,
        )
    ),
    error = null,
    selectedIndex = 0,
    options = listOf("Relations", "Posts")
)


    @HiltViewModel
    class ProfileViewModel @Inject constructor(
        private val relationRepository: RelationRepository,
        private val resourceRepository: ResourceRepository,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(ProfileUiState())
        val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
        init {
            _uiState.value = fakedata
        }

        fun updateSelectedIndex(index: Int) {
            _uiState.update { currentState ->
                currentState.copy(selectedIndex = index)
            }
        }

        private fun loadProfile(id: Int) {
            _uiState.update { it.copy(isLoading = true) }
            viewModelScope.launch {
                try {
                    val userRelations =
                        relationRepository.getUserRelations(id = id, page = 1, limit = 10)
                    val resources =
                        resourceRepository.getUserResources(id = id, page = 1, limit = 10)
                    val relationType = relationRepository.getRelationTypes()
                    _uiState.update { currentState ->
                        currentState.copy(
                            isLoading = false,
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