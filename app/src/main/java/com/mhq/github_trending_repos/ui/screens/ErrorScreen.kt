package com.mhq.github_trending_repos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(contentPadding)
            .fillMaxSize()
    ) {
        Text(
            text = "Network error. Please, retry.",
            modifier = Modifier
                .padding(16.dp)
        )
        Button(
            onClick = retryAction
        ) {
            Text("Retry")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview(){
    ErrorScreen({}, contentPadding = PaddingValues(0.dp))
}