package com.example.composecourseyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import kotlin.random.Random

class StateHandleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.fillMaxSize()) {

                val color= remember { mutableStateOf(Color.Yellow) }

                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                ){
                    // returning lambda function color value
                    color.value=it
                }
                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())
            }

        }
    }
}
@Composable
fun ColorBox(
    modifier: Modifier=Modifier,
    updateColor:(Color)->Unit // calling lambda function to return color value
){
    Box(modifier = modifier
        .background(color = Color.Red)
        .clickable {
            updateColor( // setting lambda function color value
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )
}