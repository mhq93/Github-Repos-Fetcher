package com.mhq.github_trending_repos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mhq.github_trending_repos.ui.components.RepoCard

@Composable
fun ReposScreen(modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(30) {
            RepoCard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReposScreenPreview(){
    ReposScreen()
}