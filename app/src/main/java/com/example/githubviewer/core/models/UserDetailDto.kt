package com.example.githubviewer.core.models

import com.google.gson.annotations.SerializedName

data class UserDetailDto(
    @SerializedName("name")
    val fullName: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("following")
    val following: Int,
    @SerializedName("bio")
    val bio: String?,
    @SerializedName("public_repos")
    val publicRepository: Int,
    @SerializedName("public_gists")
    val publicGists: Int,
    @SerializedName("updated_at")
    val updateDate: String
)
