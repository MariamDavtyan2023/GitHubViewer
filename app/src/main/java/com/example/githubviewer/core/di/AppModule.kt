package com.example.githubviewer.core.di

import com.example.githubviewer.core.net.GitHubApi
import com.example.githubviewer.data.GitHubRepositoryImpl
import com.example.githubviewer.domain.GetUserDetailsUseCase
import com.example.githubviewer.domain.GetUsersUseCase
import com.example.githubviewer.domain.GitHubRepository
import com.example.githubviewer.ui.user_details.UserDetailsViewModel
import com.example.githubviewer.ui.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    // Retrofit instance
    single<GitHubApi> {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)
    }

    // Repository implementation
    single<GitHubRepository> { GitHubRepositoryImpl(get()) }

    viewModel { UsersViewModel(get()) }
    viewModel { UserDetailsViewModel(get()) }

    // Use cases
    factory { GetUsersUseCase(get()) }
    factory { GetUserDetailsUseCase(get()) }
}