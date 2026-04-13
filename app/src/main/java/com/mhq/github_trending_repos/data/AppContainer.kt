package com.mhq.github_trending_repos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mhq.github_trending_repos.data.network.GithubApiService
import com.mhq.github_trending_repos.data.repository.GithubRepository
import com.mhq.github_trending_repos.data.repository.NetworkRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val githubRepository: GithubRepository
}

class DefaultAppContainer: AppContainer{
    private val baseUrl = "https://api.github.com/"
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: GithubApiService by lazy {
        retrofit.create(GithubApiService::class.java)
    }

    override val githubRepository: GithubRepository by lazy {
        NetworkRepository(retrofitService)
    }
}