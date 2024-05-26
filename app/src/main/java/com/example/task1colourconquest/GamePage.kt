package com.example.task1colourconquest

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.task1colourconquest.ui.theme.fontFamily
import com.example.task1colourconquest.ui.theme.fontFamily2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamePage(navController: NavController, viewModel1: TimerViewModel1, viewModel2: TimerViewModel2) {

    var exitDialog by remember { mutableStateOf(false) }
    mins1.value = mins.value.toInt()
    mins2.value = mins.value.toInt()
    secs1.value = secs.value.toInt()
    secs2.value = secs.value.toInt()

    if(exitDialog) {
        AlertDialog(onDismissRequest = {

            exitDialog = false
        },
            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {
                        exitDialog = false
                    },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(10)
                    ) {
                        Text(
                            text = "Continue",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            exitDialog = false
                            navController.navigate(Screen.HomePage.route)
                            counter.value = 0
                            for(b in 0..1){
                                for(t in 0..<r.value * c.value){
                                    playerPoints[b][t] = 0
                                }
                            }
                            backgroundColor.value = Color(0xFFED6A5E)
                            pointsTotal[0] = 0
                            pointsTotal[1] = 0
                            for(i in 0 .. 1) {
                                for (j in 0..<r.value * c.value) {
                                    colorTile[j] = Color(0xFFF2E6D1)
                                    playerCover[i][j] = false
                                }
                            }
                            thisPlayer.value = 1
                            otherPlayer.value = 0
                            player1Name.value = ""
                            player2Name.value = ""
                        },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(10)
                        ) {
                        Text(
                            text = "Leave Game",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            counter.value = 0
                            for(b in 0..1){
                                for(t in 0..<r.value * c.value){
                                    playerPoints[b][t] = 0
                                }
                            }
                            backgroundColor.value = Color(0xFFED6A5E)
                            pointsTotal[0] = 0
                            pointsTotal[1] = 0
                            for(i in 0 .. 1) {
                                for (j in 0..<r.value * c.value) {
                                    colorTile[j] = Color(0xFFF2E6D1)
                                    playerCover[i][j] = false
                                }
                            }
                            thisPlayer.value = 1
                            otherPlayer.value = 0
                            exitDialog = false
                        },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(10)
                    ) {
                        Text(
                            text = "Reset Grid",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Are you Sure?",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF0FA6F7)
                    )
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColoringBG[thisPlayer.value]),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.height(84.dp),
                verticalArrangement = Arrangement.Bottom,
            ){

                Row{
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .widthIn(min = 80.dp)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(48,50,58),
                            contentColor = Color(0xFF323232)
                        ),
                        border = BorderStroke(
                            width = 4.dp,
                            color = Color.Black
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 16.dp
                        ),
                        shape = RoundedCornerShape(
                            topEndPercent = 50,
                            bottomEndPercent = 50
                        )
                    ){
                        Text(
                            text = pointsTotal[0].toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = Color(0xFF0FA6F7)
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    Button(
                        onClick = {},
                        contentPadding = (
                                    PaddingValues(
                                        start = 32.dp,
                                        top = 0.dp,
                                        end = 16.dp,
                                        bottom = 0.dp
                                    )
                                ),
                        modifier = Modifier
                            .width(IntrinsicSize.Max)
                            .height(56.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    topEndPercent = 10,
                                    bottomEndPercent = 10
                                )
                            ),
                        shape = CutCornerShape(
                            topStartPercent = 45,
                            bottomStartPercent = 45,
                        ),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color(0xFF0FA6F7),
                            containerColor = Color(48,50,58)
                        ),
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Black
                        )
                    ){
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){

                            Text(
                                text = if (player2Name.value != "") player2Name.value.uppercase() else "PLAYER 2",
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                color = Color(0xFF0FA6F7),
                                modifier = Modifier.rotate(180f)
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.width(84.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Box (
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        modifier = Modifier
                            .size(48.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Gray
                        ),
                        shape = RoundedCornerShape(percent = 50),
                        onClick = {
                            exitDialog = true
                        }
                    ) {

                    }
                    Text(
                        text = "X",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
        ){
            Spacer(modifier = Modifier.width(20.dp))
            if (mode.value == 2 && timedOrNot.value) {
                Row{
                    viewModel2.apply{
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(60.dp)
                                .width(IntrinsicSize.Max),
                            contentPadding = PaddingValues(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(48,50,58), //143,252,84
                                contentColor = Color(0xFFED6A5E)
                            ),
                            border = BorderStroke(
                                width = 4.dp,
                                color = Color(25,50,25)
                            ),
                            shape = RoundedCornerShape(25)

                        ){
                            Text(
                                text = timerText.value,
                                modifier = Modifier.rotate(180f),
                                fontFamily = fontFamily2,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                color = Color(143,252,84)
                            )
                        }
                    }
                }
            } else {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){

            LazyVerticalGrid(
                modifier = Modifier.width(375.dp),
                columns = GridCells.Fixed(5),
            ) {
                items(r.value * c.value){ i->
                    Box(
                        modifier = Modifier
                            .height(72.dp)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ){

                            Button(
                                modifier = Modifier
                                    .fillMaxSize(),
                                shape = RoundedCornerShape(percent = 15),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorTile[i]
                                ),
                                onClick = {
                                    clicked[i] = true
                                },
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 8.dp,
                                    pressedElevation = 12.dp
                                )
                            ){

                            }
                            
                            val sizeCircle by animateFloatAsState(
                                targetValue = if (sizeOfCircle[i] || sizeOfOtherCircle[i]) 0.8f else 0f,
                                animationSpec = tween(durationMillis = 2000)
                            )

                            Button (
                                onClick = {
                                    clicked[i] = true
                                },
                                modifier = Modifier
                                    .fillMaxSize(sizeCircle),
                                shape = RoundedCornerShape(percent = 50),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorCircle[i],
                                ),
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 8.dp
                                )
                            ){

                            }

                            Text(
                                text = if (playerPoints[0][i] == 0 && playerPoints[1][i] == 0) "" else if (playerPoints[0][i] == 0) playerPoints[1][i].toString() else playerPoints[0][i].toString(),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 32.sp,
                                color = Color.White
                            )
                        }
                    }

                    if(clicked[i]) {
                        allowClick(i)
                        if (counter.value % 2 == 1){
                            viewModel1.stopCountDownTimer()
                            viewModel2.startCountDownTimer()
                        }
                        else {
                            viewModel2.stopCountDownTimer()
                            viewModel1.startCountDownTimer()
                        }

                        clicked[i] = false
                    }
                    if (!viewModel1.isTimeRemaining.value){
                        winnerName.value = if (player2Name.value != "") player2Name.value else "PLAYER 2"
                        winner.value = 0
                    } else if (!viewModel2.isTimeRemaining.value){
                        winnerName.value = if (player1Name.value != "") player1Name.value else "PLAYER 1"
                        winner.value = 1
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            if (mode.value == 2 && timedOrNot.value){
                Row{
                    viewModel1.apply{
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(60.dp)
                                .width(IntrinsicSize.Max),
                            contentPadding = PaddingValues(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(48,50,58), //143,252,84
                                contentColor = Color(0xFFED6A5E)
                            ),
                            border = BorderStroke(
                                width = 4.dp,
                                color = Color(25,50,25)
                            ),
                            shape = RoundedCornerShape(25)

                        ){
                            Text(
                                text = timerText.value,
                                fontFamily = fontFamily2,
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                color = Color(143,252,84)
                            )
                        }
                    }
                }
            } else {
                Spacer(modifier = Modifier.height(60.dp))
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Button(
                onClick = {},
                contentPadding = (
                        PaddingValues(
                            start = 16.dp,
                            top = 0.dp,
                            end = 32.dp,
                            bottom = 0.dp
                        )
                        ),
                modifier = Modifier
                    .height(56.dp)
                    .width(IntrinsicSize.Max)
                    .clip(
                        shape = RoundedCornerShape(
                            topStartPercent = 10,
                            bottomStartPercent = 10
                        )
                    ),
                shape = CutCornerShape(
                    topEndPercent = 45,
                    bottomEndPercent = 45,
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(48,50,58),
                    contentColor = Color(0xFFED6A5E)
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Black
                )
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = if (player1Name.value != "") player1Name.value.uppercase() else "PLAYER 1",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color(0xFFED6A5E)
                    )
                }
            }

            Spacer(modifier = Modifier.width(6.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .widthIn(min = 80.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(48,50,58),
                    contentColor = Color(0xFF323232)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 16.dp
                ),
                border = BorderStroke(
                    width = 4.dp,
                    color = Color.Black
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 50,
                    bottomStartPercent = 50
                )
            ){
                Text(
                    text = pointsTotal[1].toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color(0xFFED6A5E)
                )
            }
        }
    }
    if (winner.value != -1) {
        if (winner.value == 0) {
            DisplayWinner(navController = navController)
        } else if (winner.value == 1) {
            DisplayWinner(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GamePagePreview() {
    GamePage(navController = rememberNavController(), viewModel1 = viewModel(), viewModel2 = viewModel())
}

