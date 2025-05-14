package com.cesi.ressourcesrelationnelles.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.cesi.ressourcesrelationnelles.data.model.Relation
import com.cesi.ressourcesrelationnelles.data.model.RelationType
import com.cesi.ressourcesrelationnelles.data.model.Resource
import com.cesi.ressourcesrelationnelles.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

data class ProfileUiState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val relations: List<Relation>? = emptyList(),
    val relationType: List<RelationType> = emptyList(),
    val resources: List<Resource> = emptyList(),
    val error: String? = null,
    val selectedIndex: Int = 0,
    val options: List<String> = listOf("Relations", "Posts")
)

@HiltViewModel
class ProfileViewModel @Inject constructor(

) : ViewModel() {
    var uiState = ProfileUiState()
        private set

    fun updateSelectedIndex(index: Int) {
        uiState = uiState.copy(selectedIndex = index)
    }
}