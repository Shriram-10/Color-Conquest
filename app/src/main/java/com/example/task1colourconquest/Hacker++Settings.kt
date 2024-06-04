package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HackerPlusSettings(navController: NavController, highScoreManager: HighScoreManager = HighScoreManager(LocalContext.current)){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                gradientBackground(
                    colors = if (darkLight.value == 1) gradientColorList[1] else gradientColorList[0],
                    isVerticalGradient = true
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var chooseMultiplayer by remember {mutableStateOf(false)}
        var chooseBot by remember {mutableStateOf(false)}
        var selectNoOfPlayers by remember { mutableStateOf(false) }

        AnimatedVisibility(
            visible = chooseMultiplayer,
            enter = slideIn(
                initialOffset = {fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(durationMillis = 200)
            ),
            exit = slideOut(
                targetOffset = {fullSize -> IntOffset( -fullSize.width,0) },
                animationSpec = tween(durationMillis = 200)
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
                    containerColor = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp,
                    pressedElevation = 12.dp
                ),
                shape = RoundedCornerShape(5)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Choose No. Of Players : ",
                            color = if (darkLight.value == 1) Color.White else Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .width(IntrinsicSize.Min)
                                .clip(RoundedCornerShape(10))
                        ){
                            Button(
                                onClick = {
                                    selectNoOfPlayers = !selectNoOfPlayers
                                },
                                modifier = Modifier
                                    .height(44.dp)
                                    .width(100.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E),
                                ),
                                shape = RoundedCornerShape(15),
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 12.dp
                                )
                            ){
                                Text(
                                    text = if (noOfPlayers.value == 2) "Select" else noOfPlayers.value.toString(),
                                    color = if (darkLight.value == 1) Color.Black else Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            AnimatedVisibility(
                                visible = selectNoOfPlayers
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .background(
                                            if (darkLight.value == 1) Color(
                                                237,
                                                212,
                                                224
                                            ) else Color(0xFFF2D1CD)
                                        )
                                        .clip(RoundedCornerShape(20))
                                ) {
                                    Button(
                                        onClick = {
                                            noOfPlayers.value = 2
                                            selectNoOfPlayers = false
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(
                                                237,
                                                212,
                                                224
                                            ) else Color(0xFFF2D1CD)
                                        ),
                                        modifier = Modifier
                                            .height(40.dp)
                                            .width(100.dp),
                                        shape = RoundedCornerShape(5)
                                    ) {
                                        Text(
                                            text = "2",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Gray
                                        )
                                    }
                                    Button(
                                        onClick = {
                                            noOfPlayers.value = 3
                                            selectNoOfPlayers = false
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(
                                                237,
                                                212,
                                                224
                                            ) else Color(0xFFF2D1CD)
                                        ),
                                        modifier = Modifier
                                            .height(40.dp)
                                            .width(100.dp),
                                        shape = RoundedCornerShape(5)
                                    ) {
                                        Text(
                                            text = "3",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Gray
                                        )
                                    }

                                    Button(
                                        onClick = {
                                            noOfPlayers.value = 4
                                            selectNoOfPlayers = false
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(
                                                237,
                                                212,
                                                224
                                            ) else Color(0xFFF2D1CD)
                                        ),
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(40.dp),
                                        shape = RoundedCornerShape(5)
                                    ) {
                                        Text(
                                            text = "4",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Gray
                                        )
                                    }
                                    Button(
                                        onClick = {
                                            noOfPlayers.value = 5
                                            selectNoOfPlayers = false
                                        },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(
                                                237,
                                                212,
                                                224
                                            ) else Color(0xFFF2D1CD)
                                        ),
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(40.dp),
                                        shape = RoundedCornerShape(5),
                                    ) {
                                        Text(
                                            text = "5",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }

        if (chooseMultiplayer){
            Spacer(modifier = Modifier.height(20.dp))
        }

        Button(
            onClick = {
                if (chooseBot){
                    chooseBot = false
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(400)
                        chooseMultiplayer = !chooseMultiplayer
                    }
                } else {
                    chooseMultiplayer = !chooseMultiplayer
                }
            },
            modifier = Modifier
                .height(70.dp)
                .width(220.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E),
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(20)
        ){
            Text(
                text = "MultiPlayer Mode",
                color = if (darkLight.value == 1) Color.Black else Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (chooseMultiplayer){
                    chooseMultiplayer = false
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(400)
                        chooseBot = !chooseBot
                    }
                } else {
                    chooseBot = !chooseBot
                }
            },
            modifier = Modifier
                .height(70.dp)
                .width(220.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E),
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(20)
        ){
            Text(
                text = "Play v/s Bot",
                color = if (darkLight.value == 1) Color.Black else Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (chooseBot){
            Spacer(modifier = Modifier.height(20.dp))
        }

        AnimatedVisibility(
            visible = chooseBot,
            enter = slideIn(
                initialOffset = {fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(durationMillis = 200)
            ),
            exit = slideOut(
                targetOffset = {fullSize -> IntOffset( -fullSize.width,0) },
                animationSpec = tween(durationMillis = 200)
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
                    containerColor = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp,
                    pressedElevation = 12.dp
                ),
                shape = RoundedCornerShape(5)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

            },
            modifier = Modifier.height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(25.dp)
        ){
            Text(
                text = "Next",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
