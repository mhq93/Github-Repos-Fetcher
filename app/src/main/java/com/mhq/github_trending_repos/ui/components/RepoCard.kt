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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun RepoCard(modifier: Modifier = Modifier){
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
                text = "[Repo Name]",
                color = Color.Black
            )
        }
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Row(){
            Text(
                text = "[Repo Description]",
                color = Color.Black
            )
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
                SubcomposeAsyncImage(
                    model = "https://placeholder.com/image.jpg",
                    contentDescription = "Owner Avatar",
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape),
                    loading = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null
                        )
                    },
                    error = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null
                        )
                    }
                )
//                AsyncImage(
//                    model = "https://placeholder.com/image.jpg",
//                    contentDescription = "Owner Avatar",
//                    placeholder = rememberVectorPainter(Icons.Default.Person),
//                    modifier = Modifier
//                        .size(24.dp)
//                        //.background(Color.Cyan)
//                        .clip(CircleShape)
//                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "[Repo Owner Name]",
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
                    text = "[Number of Stars]",
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
    RepoCard(modifier = Modifier)
}
