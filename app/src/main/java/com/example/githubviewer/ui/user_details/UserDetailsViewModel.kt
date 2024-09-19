package com.example.githubviewer.ui.user_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubviewer.core.models.UserDetailDto
import com.example.githubviewer.domain.GetUserDetailsUseCase
import kotlinx.coroutines.launch

class UserDetailsViewModel(private val getUserDetailsUseCase: GetUserDetailsUseCase): ViewModel(){

    private val _userDetails = MutableLiveData<UserDetailDto>()
    val userDetails: LiveData<UserDetailDto>
        get() = _userDetails

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun loadUserDetails(username: String) {
        viewModelScope.launch {

            try {
                _userDetails.value = getUserDetailsUseCase.execute(username)
            } catch (e: Exception) {
                _error.value = "Failed to load user details"
            }

        }
    }
}