package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HackerSettings(navController: NavController){

    var isTimerVisible by remember {mutableStateOf(false)}
    var isSeriesVisible by remember {mutableStateOf(false)}
    var makeDelay by remember {mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground(
                    isVerticalGradient = true,
                    colors = gradientColorList
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AnimatedVisibility(
            visible = isSeriesVisible,
            enter = slideIn(
                initialOffset = {fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = slideOut(
                targetOffset = {fullSize -> IntOffset( -fullSize.width,0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(5))
        ) {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxSize(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2E6D1)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp,
                    pressedElevation = 12.dp
                ),
                shape = RoundedCornerShape(5)
            ){

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if(isTimerVisible){
                    isTimerVisible = false
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                        isSeriesVisible = !isSeriesVisible
                    }
                } else {
                    isSeriesVisible = !isSeriesVisible
                }
            }
                ,
            modifier = Modifier.height(70.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED6A5E)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(20)
        ){
            Text(
                text = "Series Settings",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (isSeriesVisible){
                    isSeriesVisible = false
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                        isTimerVisible = !isTimerVisible
                    }
                } else {
                    isTimerVisible = !isTimerVisible
                }
            },
            modifier = Modifier.height(70.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED6A5E)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(20)
        ){
            Text(
                text = "Timer Settings",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = isTimerVisible,
            enter = slideIn(
                initialOffset = {fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = slideOut(
                targetOffset = {fullSize -> IntOffset( -fullSize.width,0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(5))
        ) {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2E6D1)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp,
                    pressedElevation = 12.dp
                ),
                shape = RoundedCornerShape(5)
            ){

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(Screen.PlayerInformation.route)
            },
            modifier = Modifier.height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0FA6F7)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(25.dp)
        ){
            Text(
                text = "Enter Series",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HackerSettingsPreview(){
    HackerSettings(navController = NavController(LocalContext.current))
}