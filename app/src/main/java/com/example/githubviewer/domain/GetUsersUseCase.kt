package com.example.githubviewer.domain

import com.example.githubviewer.core.models.UserDto

class GetUsersUseCase(private val repository: GitHubRepository) {
    suspend fun execute(): List<UserDto> {
        return repository.getUsers()
    }
}