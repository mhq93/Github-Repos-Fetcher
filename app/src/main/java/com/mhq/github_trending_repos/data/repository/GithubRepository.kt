package com.mhq.github_trending_repos.data.repository

import com.mhq.github_trending_repos.data.model.Repo
import com.mhq.github_trending_repos.data.network.GithubApiService
import java.util.Calendar

interface GithubRepository {
    suspend fun provideGithubRepos(page: Int): List<Repo>
}

class NetworkRepository(private val githubApiService: GithubApiService): GithubRepository {
    private fun getDateThirtyDaysAgo(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -30)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return "$year-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}"
    }

    override suspend fun provideGithubRepos(page: Int): List<Repo> {
         return githubApiService.getRepos(
            query = "created:>${getDateThirtyDaysAgo()}",
            sort = "stars",
            order = "desc",
            page = page
        ).repoSearchResponseItems
    }
}