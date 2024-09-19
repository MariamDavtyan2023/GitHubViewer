package com.example.githubviewer.domain

import com.example.githubviewer.core.models.UserDetailDto
import com.example.githubviewer.core.models.UserDto

interface GitHubRepository {
    suspend fun getUsers(): List<UserDto>
    suspend fun getUserDetails(username: String): UserDetailDto
}