package com.cesi.ressourcesrelationnelles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesi.ressourcesrelationnelles.data.dto.response.UserDto
import com.cesi.ressourcesrelationnelles.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _user = MutableStateFlow<UserDto?>(null)
    val user: StateFlow<UserDto?> = _user

    fun loadUser() {
        viewModelScope.launch {
            try {
                _user.value = userRepository.getMe()
            } catch (e: Exception) {
                _user.value = UserDto(
                    id = 1,
                    username = "John Doe",
                    email = "john.mclean@examplepetstore.com",
                    password = "password",
                    firstName = "John",
                    lastName = "Doe",
                    dateOfBirth = "1990-01-01",
                    profilePicture = "https://picsum.photos/100",
                    phone = "123-456-7890",
                    address = "123 Main St",
                    city = "New York",
                    country = "USA",
                    zipcode = "10001",
                    createdAt = "15h",
                    updatedAt = "16h",
                    role = 1,
                    isActive = true,
                    lastLogin = "17h",
                )
            }
        }
    }
}