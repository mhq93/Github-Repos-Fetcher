package com.mhq.github_trending_repos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mhq.github_trending_repos.data.model.Repo
import com.mhq.github_trending_repos.ui.components.RepoCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReposScreen(
    lazyRepos: LazyPagingItems<Repo>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val pullRefreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = lazyRepos.loadState.refresh is LoadState.Loading,
        onRefresh = { lazyRepos.refresh() },
        state = pullRefreshState,
        modifier = modifier
    ) {
        LazyColumn(
            contentPadding = contentPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .nestedScroll(connection = object : NestedScrollConnection {
                    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                        return if (available.y > 0) available.copy(y = 0f) else Offset.Zero
                    }
                })
        ) {
            items(count = lazyRepos.itemCount) { index ->
                lazyRepos[index]?.let { repo ->
                    RepoCard(repo = repo)
                }
            }
            if (lazyRepos.loadState.append is LoadState.Loading) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}