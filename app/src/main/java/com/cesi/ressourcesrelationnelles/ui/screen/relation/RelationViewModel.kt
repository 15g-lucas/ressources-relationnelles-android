package com.cesi.ressourcesrelationnelles.ui.screen.relation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.request.FilterDto
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import com.cesi.ressourcesrelationnelles.data.repository.RelationRepository
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

val fakedata = listOf(
    UserRelationDto(
        id = 1,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 2,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 3,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 4,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 5,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 6,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 7,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    ),
    UserRelationDto(
        id = 8,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    )
)

data class RelationUiState(
    val users: List<UserRelationDto> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class RelationViewModel @Inject constructor(
    private val userRepository: RelationRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(RelationUiState())
    val uiState = _uiState.asStateFlow()

    fun fetchUser(userId: Int, relationTypeId: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val users = userRepository.getUserRelationByType(
                    userId = userId,
                    relationTypeId = relationTypeId
                )
                _uiState.update { it.copy(users = users, isLoading = false) }
            } catch (e: Exception) {
            }
        }
    }
}