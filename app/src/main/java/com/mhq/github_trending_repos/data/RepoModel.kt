package com.mhq.github_trending_repos.data

data class RepoModel(
    val repoName: String,
    val repoDescription: String,
    val repoOwnerAvatar: String,
    val repoOwnerName: String,
    val repoStars: Double
)