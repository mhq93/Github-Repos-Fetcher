package com.mhq.github_trending_repos.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mhq.github_trending_repos.data.model.Repo
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
interface GithubApiService {
    @GET("search/repositories")
    suspend fun getRepos(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): GithubSearchResponse
}