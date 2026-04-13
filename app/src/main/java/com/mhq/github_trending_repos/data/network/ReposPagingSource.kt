package com.mhq.github_trending_repos.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mhq.github_trending_repos.data.model.Repo
import retrofit2.HttpException
import java.io.IOException
import java.util.Calendar

class ReposPagingSource(
    private val githubApiService: GithubApiService
) : PagingSource<Int, Repo>() {

    companion object {
         const val STARTING_PAGE = 1
         const val ITEMS_PER_PAGE = 50
    }

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? {
        return state.anchorPosition?.let { anchor ->
            val anchorPage = state.closestPageToPosition(anchor)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        return try {
            val page = params.key ?: STARTING_PAGE
            val paginatedRepos = githubApiService.getRepos(
                query = "created:>${getDateThirtyDaysAgo()}",
                sort = "stars",
                order = "desc",
                page = page,
                itemsPerPage = ITEMS_PER_PAGE
            ).repoSearchResponseItems

            LoadResult.Page(
                data = paginatedRepos,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (paginatedRepos.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    private fun getDateThirtyDaysAgo(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -30)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return "$year-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}"
    }
}