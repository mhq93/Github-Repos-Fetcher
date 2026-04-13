package com.mhq.github_trending_repos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mhq.github_trending_repos.data.model.Owner
import com.mhq.github_trending_repos.data.model.Repo

@Composable
fun RepoCard(
    repo: Repo,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val color = Color.LightGray
                drawLine(
                    color = color,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = color,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            }
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 16.dp,
                bottom = 16.dp
            )
    ){
        Row(){
            Text(
                text = repo.repoName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Row(){
            repo.repoDescription?.let {
                Text(
                    text = it,
                    color = Color.Black
                )
            }
        }
        Spacer(
            modifier = Modifier
                .padding(8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ){
            Row(){
                AsyncImage(
                    model = repo.repoOwner.ownerAvatarUrl,
                    contentDescription = "Owner Avatar",
                    placeholder = rememberVectorPainter(Icons.Default.Person),
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = repo.repoOwner.ownerName,
                    color = Color.Black,
                )
            }
            Row(){
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star",
                    modifier = Modifier
                        .size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = if (repo.repoStars >= 1000) {
                        "${"%.1f".format(repo.repoStars / 1000.0)}k"
                    } else {
                        "${repo.repoStars}"
                    },
                    color = Color.Black,
                    modifier = Modifier
                        .padding(end = 4.dp)
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoCardPreview(){
    RepoCard(
        repo = Repo(
            repoName = "tensorflow",
            repoDescription = "Computation using data flow graphs",
            repoStars = 5100.0,
            repoOwner = Owner(ownerName = "tensorflow", ownerAvatarUrl = "")
        )
    )
}
