package com.mhq.github_trending_repos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner (
    @SerialName("login")
    val ownerName: String,
    @SerialName("avatar_url")
    val ownerAvatarUrl: String
)