package com.mhq.github_trending_repos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(
    @SerialName("name")
    val repoName: String,
    @SerialName("description")
    val repoDescription: String?,
    @SerialName("stargazers_count")
    val repoStars: Double,
    @SerialName("owner")
    val repoOwner: Owner
)