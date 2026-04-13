package com.mhq.github_trending_repos.viewmodel

import com.mhq.github_trending_repos.data.model.Repo

sealed interface ReposUiState{
    data class Success(val repos: List<Repo>): ReposUiState
    data object Loading: ReposUiState
    data class Error(val message: String) : ReposUiState
}