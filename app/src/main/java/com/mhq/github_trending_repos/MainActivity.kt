package com.mhq.github_trending_repos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mhq.github_trending_repos.ui.theme.GithubTrendingReposTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubTrendingReposTheme {
                GithubReposApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GithubReposAppPreview() {
    GithubTrendingReposTheme {
        GithubReposApp()
    }
}