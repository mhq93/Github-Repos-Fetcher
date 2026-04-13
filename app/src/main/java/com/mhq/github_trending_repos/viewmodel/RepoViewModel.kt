package com.mhq.github_trending_repos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mhq.github_trending_repos.GithubReposApplication
import com.mhq.github_trending_repos.data.repository.GithubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RepoViewModel(private val githubRepository: GithubRepository): ViewModel() {
    private val _reposUiState = MutableStateFlow<ReposUiState>(ReposUiState.Loading)
    val reposUiState = _reposUiState.asStateFlow()

    init {
        fetchRepos()
    }

     fun fetchRepos() {
        viewModelScope.launch {
            _reposUiState.value = ReposUiState.Loading
            _reposUiState.value = try {
                ReposUiState.Success(githubRepository.provideGithubRepos(page = 1))
            } catch (e: IOException) {
                ReposUiState.Error(e.message ?: "Network error")
            } catch (e: HttpException) {
                ReposUiState.Error(e.message ?: "Server error")
            }
        }
    }

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