package com.mhq.github_trending_repos.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mhq.github_trending_repos.data.model.Repo
import com.mhq.github_trending_repos.data.network.GithubApiService
import com.mhq.github_trending_repos.data.network.ReposPagingSource
import kotlinx.coroutines.flow.Flow

class NetworkRepository(private val githubApiService: GithubApiService): GithubRepository {
    override fun provideGithubRepos(): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(pageSize = ReposPagingSource.ITEMS_PER_PAGE),
            pagingSourceFactory = { ReposPagingSource(githubApiService) }
        ).flow
    }
}