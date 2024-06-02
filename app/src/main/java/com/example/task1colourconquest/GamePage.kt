package com.example.task1colourconquest

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.task1colourconquest.ui.theme.fontFamily2
import kotlinx.coroutines.delay

@Composable
fun GamePage(navController: NavController, highScoreManager: HighScoreManager) {

    var exitDialog by remember { mutableStateOf(false) }
    var PreviousHS : List<String> = highScoreManager.getData("name", "", "score", "", "mins", "", "secs", "")

    if(exitDialog) {
        if (counter.value % 2 == 0){
            isRunning1.value = false
        } else {
            isRunning2.value = false
        }
        AlertDialog(
            containerColor = if (darkLight.value == 1) Color(64,64,64) else Color.White,
            onDismissRequest = {
            if (counter.value % 2 == 0){
                isRunning1.value = true
            } else {
                isRunning2.value = true
            }
            exitDialog = false
        },
            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {
                        if (counter.value % 2 == 0){
                            isRunning1.value = true
                        } else {
                            isRunning2.value = true
                        }
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

                    if (noOfMatches.value == 1){
                        Button(
                            onClick = {
                                exitDialog = false
                                counter.value = 0
                                for(b in 0..1){
                                    for(t in 0..<r.value * c.value){
                                        playerPoints[b][t] = 0
                                    }
                                }
                                backgroundColor.value = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
                                pointsTotal[0] = 0
                                pointsTotal[1] = 0
                                for(i in 0 .. 1) {
                                    for (j in 0..<r.value * c.value) {
                                        colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                        playerCover[i][j] = false
                                    }
                                }
                                thisPlayer.value = 1
                                otherPlayer.value = 0
                                player1Name.value = ""
                                player2Name.value = ""
                                if (chooseHandicap.value){
                                    minsh1.value = "00"
                                    minsh2.value = "00"
                                    secsh1.value = "00"
                                    secsh2.value = "00"
                                } else {
                                    mins.value = "00"
                                    secs.value = "00"
                                }
                                navController.popBackStack(Screen.HomePage.route, false)
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
                    } else if (noOfMatches.value > 1){
                        Button(
                            onClick = {
                                exitDialog = false
                                counter.value = 0
                                for(b in 0..1){
                                    for(t in 0..<r.value * c.value){
                                        playerPoints[b][t] = 0
                                    }
                                }
                                backgroundColor.value = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
                                pointsTotal[0] = 0
                                pointsTotal[1] = 0
                                for(i in 0 .. 1) {
                                    for (j in 0..<r.value * c.value) {
                                        colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                        playerCover[i][j] = false
                                    }
                                }
                                thisPlayer.value = 1
                                otherPlayer.value = 0
                                player1Name.value = ""
                                player2Name.value = ""
                                listOfWins[noOfMatches.value - 1] = winner.value
                                winner.value = -1
                                emptyResultList()
                                noOfMatches.value = 1
                                matchCount.value = 1
                                noOfMatchesInput.value = ""
                                confirmButton.value = false
                                textFieldDisplay.value = false
                                customSeries.value = true
                                confirmCustomSeries.value = false
                                player1Wins.value = 0
                                player2Wins.value = 0
                                seriesWinner.value = -1
                                seriesWinnerName.value = ""
                                handicap.value = 0
                                chooseSeriesHandicap.value = false
                                activateAdvantage[0] = false
                                activateAdvantage[1] = false
                                showGridChangeDialog.value = false
                                optionsSeriesDialog.value = false
                                timedOrNot.value = false
                                displayChooseTime.value = false
                                if (chooseHandicap.value){
                                    minsh1.value = "00"
                                    minsh2.value = "00"
                                    secsh1.value = "00"
                                    secsh2.value = "00"
                                    chooseHandicap.value = false
                                } else {
                                    mins.value = "00"
                                    secs.value = "00"
                                }
                                navController.popBackStack(Screen.HomePage.route,false)
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
                                text = "Leave Series",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    if (noOfMatches.value > 1 && chooseSeriesHandicap.value){
                        Button(
                            onClick = {
                                counter.value = 0
                                for(b in 0..1){
                                    for(t in 0..<r.value * c.value){
                                        playerPoints[b][t] = 0
                                    }
                                }
                                backgroundColor.value = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
                                pointsTotal[0] = 0
                                pointsTotal[1] = 0
                                for(i in 0 .. 1) {
                                    for (j in 0..<r.value * c.value) {
                                        colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                        playerCover[i][j] = false
                                    }
                                }
                                thisPlayer.value = 1
                                otherPlayer.value = 0
                                handicap.value = 1
                                activateAdvantage[0] = false
                                activateAdvantage[1] = false
                                resetTimer[0] = true
                                resetTimer[1] = true
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
                    } else {
                        Button(
                            onClick = {
                                counter.value = 0
                                for(b in 0..1){
                                    for(t in 0..<r.value * c.value){
                                        playerPoints[b][t] = 0
                                    }
                                }
                                backgroundColor.value = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
                                pointsTotal[0] = 0
                                pointsTotal[1] = 0
                                for(i in 0 .. 1) {
                                    for (j in 0..<r.value * c.value) {
                                        colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                        playerCover[i][j] = false
                                    }
                                }
                                thisPlayer.value = 1
                                otherPlayer.value = 0
                                resetTimer[0] = true
                                resetTimer[1] = true
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
                        color = Color(0xFFED6A5E)
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
                            containerColor = if (darkLight.value == 1) Color(32,32,32) else Color(48,50,58),
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
                            modifier = Modifier.rotate(180f),
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7)
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
                            contentColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
                            containerColor = if (darkLight.value == 1) Color(32,32,32) else Color(48,50,58)
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
                                color = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
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
                            containerColor = if (darkLight.value == 1) Color.Black else Color.White,
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
                        color = if (darkLight.value == 1) Color.White else Color.Gray
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
                if (!chooseHandicap.value){
                    TimerClock(mins.value.toLong(),secs.value.toLong(), rotate = true, runnerController = isRunning2.value, oppId = 1)
                } else {
                    TimerClock(minsh2.value.toLong(),secsh2.value.toLong(), rotate = true, runnerController = isRunning2.value, oppId = 1)
                }
            } else {
                Spacer(modifier = Modifier.height(60.dp))
            }
            if (!activateAdvantage[0] && handicap.value == 1 && matchCount.value > 1){
                if (listOfWins[matchCount.value - 2] == 1){
                    if (mode.value == 2 && timedOrNot.value){
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    Box(
                        modifier = Modifier.size(60.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Button(
                            onClick = {
                                if (counter.value % 2 == 1){
                                    activateAdvantage[0] = true
                                }
                            },
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(percent = 50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(253,245,166)
                            )
                        ){
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = "Another",
                                tint = if (darkLight.value == 1) Color(253,245,166) else Color.Black,
                                modifier = Modifier.scale(3.0f)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            LazyVerticalGrid(
                modifier = if (r.value > c.value) Modifier
                    .width((c.value * 375 / r.value).dp)
                    .padding(4.dp)
                    .fillMaxHeight() else if (r.value < c.value) Modifier
                    .height((r.value * 375 / c.value + (r.value + 1) * 4).dp)
                    .fillMaxWidth(0.95f)
                    .padding(8.dp) else Modifier.width(375.dp),
                columns = GridCells.Fixed(c.value),
            ) {
                items(r.value * c.value){ i->
                    Box(
                        modifier = if (r.value > c.value) Modifier
                            .width((375 / r.value).dp)
                            .padding(4.dp)
                            .aspectRatio(1f) else if(r.value < c.value) Modifier
                            .height((375 / c.value).dp)
                            .padding(4.dp) else Modifier
                            .height((375 / r.value).dp)
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
                                animationSpec = tween(durationMillis = 800)
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
                            if (r.value <= 6 && c.value <= 6){
                                Text(
                                    text = if (playerPoints[0][i] == 0 && playerPoints[1][i] == 0) "" else if (playerPoints[0][i] == 0) playerPoints[1][i].toString() else playerPoints[0][i].toString(),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 32.sp,
                                    color = if (darkLight.value == 1) Color(255,245,166) else Color.White
                                )
                            } else if (c.value <= r.value){
                                Text(
                                    text = if (playerPoints[0][i] == 0 && playerPoints[1][i] == 0) "" else if (playerPoints[0][i] == 0) playerPoints[1][i].toString() else playerPoints[0][i].toString(),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 18.sp,
                                    color = if (darkLight.value == 1) Color(255,245,166) else Color.White
                                )
                            } else {
                                Text(
                                    text = if (playerPoints[0][i] == 0 && playerPoints[1][i] == 0) "" else if (playerPoints[0][i] == 0) playerPoints[1][i].toString() else playerPoints[0][i].toString(),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 18.sp,
                                    color = if (darkLight.value == 1) Color(255,245,166) else Color.White
                                )
                            }
                        }
                    }

                    if(clicked[i]) {
                        allowClick(i)
                        if (counter.value % 2 == 1){
                            isRunning1.value = false
                            isRunning2.value = true
                        }
                        else {
                            isRunning2.value = false
                            isRunning1.value = true
                        }

                        clicked[i] = false
                    }
                    if (winner.value != -1){
                        isRunning1.value = false
                        isRunning2.value = false
                        if (winner.value == 0){
                            winnerName.value = if(player2Name.value != "") player2Name.value else "PLAYER 2"
                        } else {
                            winnerName.value = if(player1Name.value != "") player1Name.value else "PLAYER 1"
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            if (!activateAdvantage[1] && handicap.value == 1 && matchCount.value > 1){
                if (listOfWins[matchCount.value - 2] == 0){
                    Box(
                        modifier = Modifier.size(60.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Button(
                            onClick = {
                                if (counter.value % 2 == 0){
                                    activateAdvantage[1] = true
                                }
                            },
                            modifier = Modifier.fillMaxSize(),
                            shape = RoundedCornerShape(percent = 50),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(253,245,166)
                            )
                        ){
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = "Another",
                                tint = if (darkLight.value == 1) Color(253,245,166) else Color.Black,
                                modifier = Modifier.scale(3.0f)
                            )
                        }
                    }
                    if (mode.value == 2 && timedOrNot.value){
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }
            }
            if (mode.value == 2 && timedOrNot.value){
                if (!chooseHandicap.value){
                    TimerClock(mins.value.toLong(),secs.value.toLong(), rotate = false, runnerController = isRunning1.value, oppId = 0, side = 1)
                } else {
                    TimerClock(minsh1.value.toLong(),secsh1.value.toLong(), rotate = false, runnerController = isRunning1.value, oppId = 0, side = 1)
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
                    containerColor = if (darkLight.value == 1) Color(32,32,32) else Color(48,50,58),
                    contentColor = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
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
                        color = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
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
                    containerColor = if (darkLight.value == 1) Color(32,32,32) else Color(48,50,58),
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
                    color = if (darkLight.value == 1) Color(216,172,225) else Color(0xFFED6A5E)
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
    if (winner.value != -1) {
        previousHSName.value = PreviousHS[0]
        if (PreviousHS[1] != ""){
            previousHS.value = PreviousHS[1].toInt()
        }
        if (PreviousHS[2] != ""){
            previousHSTime[0] = PreviousHS[2].toInt()
        }
        if (PreviousHS[3] != ""){
            previousHSTime[1] = PreviousHS[3].toInt()
        }
        currentHS.value = pointsTotal[winner.value]
        currentHSName.value = winnerName.value
        if (!chooseHandicap.value && timedOrNot.value){
            currentHSTime[0] = mins.value.toInt()
            currentHSTime[1] = secs.value.toInt()
        } else if (chooseHandicap.value && timedOrNot.value){
            if (winner.value == 1){
                currentHSTime[0] = minsh1.value.toInt()
                currentHSTime[1] = secsh1.value.toInt()
            } else {
                currentHSTime[0] = minsh2.value.toInt()
                currentHSTime[1] = secsh2.value.toInt()
            }
        }
        if (timedOrNot.value){
            if ((currentHS.value > previousHS.value) || (currentHS.value == previousHS.value && currentHSTime[0] < previousHSTime[0]) || (currentHS.value == previousHS.value && currentHSTime[0] == previousHSTime[0] && currentHSTime[1] < previousHSTime[1])){
                highScoreManager.saveData("name", winnerName.value, "score", currentHS.value.toString(), "mins", currentHSTime[0].toString(), "secs", currentHSTime[1].toString())
            }
        }
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
    GamePage(navController = rememberNavController(), highScoreManager = HighScoreManager(LocalContext.current))
}

@Composable
fun TimerClock(
    totalMins: Long = 0,
    totalSecs: Long,
    initialValue: Float = 1f,
    rotate: Boolean = false,
    runnerController: Boolean = false,
    oppId: Int,
    side: Int = 0
){
    var totalTime = totalMins * 60 + totalSecs
    var currentMins by remember {
        mutableStateOf(totalMins)
    }
    var currentSecs by remember {
        mutableStateOf(totalSecs)
    }
    var currentTime = currentMins * 60 + currentSecs
    var value by remember {
        mutableStateOf(initialValue)
    }
    var isRunning by remember {
        mutableStateOf(false)
    }
    if (runnerController){
        isRunning = true
    } else {
        isRunning = false
    }
    LaunchedEffect(key1 = currentSecs, key2 = currentMins, key3 = isRunning) {
        if (currentSecs > 0 && isRunning) {
            delay(1000)
            currentSecs -= 1
            value = currentTime / totalTime.toFloat()
        } else if (currentSecs == 0L && currentTime > 0 && isRunning){
            delay(1000)
            currentSecs = 59
            currentMins -= 1
        }
    }
    if (currentTime == 0L){
        isRunning = false
        winner.value = oppId
    }
    if (resetTimer[oppId]){
        currentMins = totalMins
        currentSecs = totalSecs
        value = 1f
        resetTimer[oppId] = false
    }

    Row{
        if (side == 1){
            Column{
                Spacer(modifier = Modifier.height(22.dp))
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .width(180.dp),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        modifier = Modifier.fillMaxSize(),
                        onClick = {},
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(100,100,100) else Color(50,50,50)
                        )
                    ){

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(0.98f),
                        horizontalArrangement = Arrangement.End
                    ){
                        Button(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth(value),
                            onClick = {},
                            shape = RoundedCornerShape(30),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (currentTime > 15) Color.Green else Color.Red
                            )
                        ){

                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
        }
        Button(
            onClick = {},
            modifier = Modifier
                .height(60.dp)
                .width(IntrinsicSize.Max),
            contentPadding = PaddingValues(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(48,50,58), //143,252,84
            ),
            border = BorderStroke(
                width = 4.dp,
                color = Color(25,50,25)
            ),
            shape = RoundedCornerShape(25)

        ){
            Text(
                text = displayString(currentMins.toString(),currentSecs.toString()),
                modifier = if (rotate) Modifier.rotate(180f) else Modifier.rotate(0f),
                fontFamily = fontFamily2,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = if (currentTime > 15) Color.Green else Color.Red
            )
        }
        if (side == 0){
            Spacer(modifier = Modifier.width(20.dp))
            Column{
                Spacer(modifier = Modifier.height(22.dp))
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .width(180.dp),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        modifier = Modifier.fillMaxSize(),
                        onClick = {},
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(50,50,50)
                        )
                    ){

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(0.98f),
                        horizontalArrangement = Arrangement.Start
                    ){
                        Button(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth(value),
                            onClick = {},
                            shape = RoundedCornerShape(30),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (currentTime > 15) Color.Green else Color.Red
                            )
                        ){

                        }
                    }
                }
            }
        }
    }
}

