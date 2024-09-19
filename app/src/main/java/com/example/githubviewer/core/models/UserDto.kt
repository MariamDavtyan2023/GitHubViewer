package com.example.githubviewer.core.models

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("login")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String
)
