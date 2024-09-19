package com.example.githubviewer.domain

import com.example.githubviewer.core.models.UserDetailDto

class GetUserDetailsUseCase(private val repository: GitHubRepository) {
    suspend fun execute(username: String): UserDetailDto {
        return repository.getUserDetails(username)
    }
}