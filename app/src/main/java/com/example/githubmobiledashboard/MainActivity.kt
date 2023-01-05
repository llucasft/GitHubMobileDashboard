package com.example.githubmobiledashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.githubmobiledashboard.ui.theme.GitHubMobileDashboardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubMobileDashboardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileInfo(
                        imageUrl = "https://avatars.githubusercontent.com/u/94794758?s=400&u=33d7e07bfb686eb15b6a42ca4f8384aebcdd17c0&v=4",
                        name = "Lucas Ferreira",
                        username = "llucasft",
                        description = "Android Developer at Google"
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileInfo(imageUrl: String, name: String, username: String, description: String) {
    Column {
        val imageSize = 100.dp
        Box(
            Modifier
                .fillMaxWidth()
                .background(
                    Color.Gray,
                    shape = RoundedCornerShape(
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                )
                .height(imageSize),
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "User photo",
                Modifier
                    .size(imageSize)
                    .offset(y = imageSize / 2)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.lucasimagem)
            )
        }
        Spacer(modifier = Modifier.height(imageSize / 2))
        Column(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = username,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = description,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileInfoPreview() {
    GitHubMobileDashboardTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileInfo(
                imageUrl = "https://avatars.githubusercontent.com/u/94794758?s=400&u=33d7e07bfb686eb15b6a42ca4f8384aebcdd17c0&v=4",
                name = "Lucas", username = "llucasft", description = "Android Developer at Google"
            )
        }
    }
}