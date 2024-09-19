package com.example.githubviewer.core.net

import com.example.githubviewer.core.models.UserDetailDto
import com.example.githubviewer.core.models.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): UserDetailDto
}