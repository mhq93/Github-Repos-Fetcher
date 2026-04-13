package com.mhq.github_trending_repos.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.mhq.github_trending_repos.data.model.Repo

@Composable
fun HomeScreen(
    lazyRepos: LazyPagingItems<Repo>,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
     when(lazyRepos.loadState.refresh) {
            is LoadState.Loading -> LoadingScreen(contentPadding = contentPadding, modifier = modifier)
            is LoadState.NotLoading -> ReposScreen(lazyRepos = lazyRepos, contentPadding = contentPadding, modifier = modifier)
            is LoadState.Error -> ErrorScreen(contentPadding = contentPadding, retryAction = retryAction, modifier = modifier)
     }
}
