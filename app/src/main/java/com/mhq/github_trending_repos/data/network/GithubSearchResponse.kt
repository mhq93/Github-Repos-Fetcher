package com.mhq.github_trending_repos.data.network

import com.mhq.github_trending_repos.data.model.Repo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubSearchResponse(
    @SerialName("total_count")
    val repoSearchResponseTotalCount: Int,
    @SerialName("items")
    val repoSearchResponseItems: List<Repo>
)