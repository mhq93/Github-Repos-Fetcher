package com.mhq.github_trending_repos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mhq.github_trending_repos.GithubReposApplication
import com.mhq.github_trending_repos.data.model.Repo
import com.mhq.github_trending_repos.data.repository.GithubRepository
import kotlinx.coroutines.flow.Flow

class RepoViewModel(private val githubRepository: GithubRepository): ViewModel() {
    val reposUiState: Flow<PagingData<Repo>> = githubRepository
        .provideGithubRepos()
        .cachedIn(viewModelScope)

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as GithubReposApplication)
                val githubRepository = application.container.githubRepository
                RepoViewModel(githubRepository = githubRepository)
            }
        }
    }
}