package com.example.githubviewer.data

import com.example.githubviewer.core.models.UserDto
import com.example.githubviewer.core.models.UserDetailDto
import com.example.githubviewer.core.net.GitHubApi
import com.example.githubviewer.domain.GitHubRepository

class GitHubRepositoryImpl(private val api: GitHubApi) : GitHubRepository {

    override suspend fun getUsers(): List<UserDto> {
        return api.getUsers()
    }

    override suspend fun getUserDetails(username: String): UserDetailDto {
        return api.getUserDetails(username)
    }
}