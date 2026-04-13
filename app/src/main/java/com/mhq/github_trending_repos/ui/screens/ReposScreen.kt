package com.mhq.github_trending_repos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhq.github_trending_repos.data.model.Owner
import com.mhq.github_trending_repos.data.model.Repo
import com.mhq.github_trending_repos.ui.components.RepoCard

@Composable
fun ReposScreen(
    reposList: List<Repo>,
    modifier: Modifier,
    contentPadding: PaddingValues
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(reposList.size) { index ->
            RepoCard(repo = reposList[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReposScreenPreview() {
    ReposScreen(
        reposList = listOf(
            Repo(
                repoName = "tensorflow",
                repoDescription = "Computation using data flow graphs",
                repoStars = 5100.0,
                repoOwner = Owner(ownerName = "tensorflow", ownerAvatarUrl = "")
            ),
            Repo(
                repoName = "kotlin",
                repoDescription = "The Kotlin programming language",
                repoStars = 3200.0,
                repoOwner = Owner(ownerName = "JetBrains", ownerAvatarUrl = "")
            )
        ),
        modifier = Modifier,
        contentPadding = PaddingValues(0.dp)
    )
}