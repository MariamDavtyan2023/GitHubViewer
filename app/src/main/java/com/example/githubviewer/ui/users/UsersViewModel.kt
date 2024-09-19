package com.example.githubviewer.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubviewer.core.models.UserDto
import com.example.githubviewer.domain.GetUsersUseCase
import kotlinx.coroutines.launch

class UsersViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _users = MutableLiveData<List<UserDto>>()
    val users: LiveData<List<UserDto>>
        get() = _users

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun loadUsers() {
        viewModelScope.launch {
            try {
                _users.value = getUsersUseCase.execute()
            } catch (e: Exception) {
                _error.value = "Failed to load users"
            }
        }
    }
}