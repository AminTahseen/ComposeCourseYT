package com.example.composecourseyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.nowayhome)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                for (i in 0..5) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {
                        SocialMediaPost(
                            painter,
                            modifier = Modifier,
                            userName = "Amin Tahseen",
                            status = "Online"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SocialMediaPost(
    painter: Painter,
    userName: String,
    status: String,
    modifier: Modifier,
) {
    Card(
        modifier = modifier
            .border(0.dp, Color.Black),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row( // Profile row start
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                ) {
                    Image(
                        painter = painter, contentDescription = userName,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(50.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                        .height(45.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = userName, style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Text(
                        text = status, style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Green
                        )
                    )
                }
            } // Profile row end

            Spacer(modifier = modifier.height(10.dp))
            Box( // media post start
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painter,
                    contentDescription = userName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }// media post end
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box( // similar to stack in flutter
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f,
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        }
    }
}

@Composable
fun ArtistCard(painter: Painter, director: String, rating: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.fillMaxWidth(0.5f),
            painter = painter,
            contentDescription = "demo",
            contentScale = ContentScale.FillBounds
        )
        Column {
            Text(director)
            Text(rating)
        }
    }
}

/*
* Columns :-
*  Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .border(5.dp,Color.Black)
            ) {
                Text(text = "Hello", modifier = Modifier
                    .offset(0.dp,20.dp)
                    .clickable {

                    }
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "World")
            }
*
* */

