package com.mhq.github_trending_repos.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhq.github_trending_repos.viewmodel.ReposUiState

@Composable
fun HomeScreen(
    reposUiState: ReposUiState,
    retryAction: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
){
     when(reposUiState) {
            is ReposUiState.Loading -> LoadingScreen(contentPadding = contentPadding, modifier = modifier)
            is ReposUiState.Success -> ReposScreen(reposList = reposUiState.repos, contentPadding = contentPadding, modifier = modifier)
            is ReposUiState.Error -> ErrorScreen(retryAction, contentPadding = contentPadding, modifier = modifier)
        }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        reposUiState = ReposUiState.Loading,
        retryAction = {}
    )
}
