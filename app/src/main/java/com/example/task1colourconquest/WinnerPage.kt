package com.example.task1colourconquest

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun DisplayWinner(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        if (noOfMatches.value == 1) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(275.dp)
                    .height(290.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(62,65,113),
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 12.dp
                )
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        modifier = Modifier.width(275.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ){
                        Text(
                            text = winnerName.value.uppercase(),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 26.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = if (darkLight.value == 1) R.drawable.darkwinner else R.drawable.winner),
                        contentDescription = "winner",
                        modifier = Modifier.aspectRatio(16f/5f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "WINS!",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 26.sp
                    )

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
                                    colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                    playerCover[i][j] = false
                                }
                            }
                            thisPlayer.value = 1
                            otherPlayer.value = 0
                            resetTimer[0] = true
                            resetTimer[1] = true
                            winner.value = -1
                        },
                        modifier = Modifier
                            .width(275.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(132,105,199) else Color(87,190,235),
                            contentColor = Color.White
                        )
                    ){
                        Text(
                            text = "Play Again",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 25.sp
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
                                    colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                    playerCover[i][j] = false
                                }
                            }
                            thisPlayer.value = 1
                            otherPlayer.value = 0
                            player1Name.value = ""
                            player2Name.value = ""
                            winner.value = -1
                            if (chooseHandicap.value){
                                minsh1.value = ""
                                minsh2.value = ""
                                secsh1.value = ""
                                secsh2.value = ""
                            } else {
                                mins.value = ""
                                secs.value = ""
                            }
                            navController.popBackStack(Screen.HomePage.route,false)
                        },
                        modifier = Modifier
                            .width(275.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(238,164,223) else Color(237,106,94),
                            contentColor = Color.White
                        )
                    ){
                        Text(
                            text = "Home",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        } else if (noOfMatches.value > 1 && matchCount.value < noOfMatches.value){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(275.dp)
                    .height(IntrinsicSize.Min),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(62,65,113),
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 12.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = Modifier.width(275.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ){
                        Text(
                            text = winnerName.value.uppercase(),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 26.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = if (darkLight.value == 1) R.drawable.darkwinner else R.drawable.winner),
                        contentDescription = "winner",
                        modifier = Modifier.aspectRatio(16f/5f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "WINS!",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 26.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth(0.48f)
                                .height(180.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(242,230,209)
                            ),
                            shape = RoundedCornerShape(20),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 12.dp
                            )
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Person",
                                    tint = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E),
                                    modifier = Modifier.height(50.dp).aspectRatio(1f)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = if (player1Name.value != "") player1Name.value.uppercase() else "PLAYER 1",
                                    fontWeight = FontWeight.Bold,
                                    color = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E),
                                    fontSize = 13.sp
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Box(
                                    modifier = Modifier.height(70.dp),
                                    contentAlignment = Alignment.Center
                                ){
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .height(70.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E)
                                        ),
                                        shape = RoundedCornerShape(20),
                                        elevation = ButtonDefaults.buttonElevation(
                                            defaultElevation = 12.dp
                                        )
                                    ){

                                    }

                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = "WINS",
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 12.sp
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Text(
                                            text = listOfWins.count{ it == 1 }.toString(),
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(242,230,209)
                            ),
                            shape = RoundedCornerShape(20),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 12.dp
                            )
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Person",
                                    tint = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
                                    modifier = Modifier.height(50.dp).aspectRatio(1f)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = if (player2Name.value != "") player2Name.value.uppercase() else "PLAYER 2",
                                    fontWeight = FontWeight.Bold,
                                    color = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
                                    fontSize = 13.sp
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Box(
                                    modifier = Modifier.height(70.dp),
                                    contentAlignment = Alignment.Center
                                ){
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .height(70.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7)
                                        ),
                                        shape = RoundedCornerShape(20),
                                        elevation = ButtonDefaults.buttonElevation(
                                            defaultElevation = 12.dp
                                        )
                                    ){

                                    }

                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = "WINS",
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 12.sp
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Text(
                                            text = listOfWins.count{ it == 0 }.toString(),
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

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
                                    colorTile[j] = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
                                    playerCover[i][j] = false
                                }
                            }
                            thisPlayer.value = 1
                            otherPlayer.value = 0
                            resetTimer[0] = true
                            resetTimer[1] = true
                            winner.value = -1
                            matchCount.value += 1
                        },
                        modifier = Modifier
                            .width(275.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(132,105,199) else Color(87,190,235),
                            contentColor = Color.White
                        )
                    ){
                        Text(
                            text = "Next Match",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 25.sp
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
                            showGridChangeDialog.value = false
                            optionsSeriesDialog.value = false
                            timedOrNot.value = false
                            displayChooseTime.value = false
                            if (chooseHandicap.value){
                                minsh1.value = ""
                                minsh2.value = ""
                                secsh1.value = ""
                                secsh2.value = ""
                                chooseHandicap.value = false
                            } else {
                                mins.value = ""
                                secs.value = ""
                            }
                            navController.popBackStack(Screen.HomePage.route, false)
                        },
                        modifier = Modifier
                            .width(275.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(238,164,223) else Color(237,106,94),
                            contentColor = Color.White
                        )
                    ){
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        } else {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(275.dp)
                    .height(IntrinsicSize.Min),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(62,65,113),
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 12.dp
                )
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = Modifier.width(275.dp),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        )
                    ){
                        Text(
                            text = if (seriesResultDeterminer() != "TIE!") seriesResultDeterminer() else "NO RESULT",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 26.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = if (darkLight.value == 1) R.drawable.darkwinner else R.drawable.winner),
                        contentDescription = "winner",
                        modifier = Modifier.aspectRatio(16f/5f)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    if (seriesResultDeterminer() != "TIE!"){
                        Text(
                            text = "WINS THE SERIES!",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 26.sp
                        )
                    } else {
                        Text(
                            text = "SERIES TIED!",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 26.sp
                        )
                    }


                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth(0.48f)
                                .height(180.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(242,230,209)
                            ),
                            shape = RoundedCornerShape(20),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 12.dp
                            )
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Person",
                                    tint = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E),
                                    modifier = Modifier.height(50.dp).aspectRatio(1f)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    textAlign = TextAlign.Center,
                                    text = if (player1Name.value != "") player1Name.value.uppercase() else "PLAYER 1",
                                    fontWeight = FontWeight.Bold,
                                    color = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E),
                                    fontSize = 13.sp
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Box(
                                    modifier = Modifier.height(70.dp),
                                    contentAlignment = Alignment.Center
                                ){
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .height(70.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E)
                                        ),
                                        shape = RoundedCornerShape(20),
                                        elevation = ButtonDefaults.buttonElevation(
                                            defaultElevation = 12.dp
                                        )
                                    ){

                                    }

                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = "WINS",
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 12.sp
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Text(
                                            text = listOfWins.count{ it == 1 }.toString(),
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(242,230,209)
                            ),
                            shape = RoundedCornerShape(20),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 12.dp
                            )
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    Icons.Filled.Person,
                                    contentDescription = "Person",
                                    tint = if (darkLight.value == 1) Color(132,105,199) else Color(0xFF0FA6F7),
                                    modifier = Modifier.height(50.dp).aspectRatio(1f)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = if (player2Name.value != "") player2Name.value.uppercase() else "PLAYER 2",
                                    fontWeight = FontWeight.Bold,
                                    color = if (darkLight.value == 1) Color(132,105,199) else Color(0xFF0FA6F7),
                                    fontSize = 13.sp
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Box(
                                    modifier = Modifier.height(70.dp),
                                    contentAlignment = Alignment.Center
                                ){
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .height(70.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = if (darkLight.value == 1) Color(132,105,199) else Color(0xFF0FA6F7)
                                        ),
                                        shape = RoundedCornerShape(20),
                                        elevation = ButtonDefaults.buttonElevation(
                                            defaultElevation = 12.dp
                                        )
                                    ){

                                    }

                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = "WINS",
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 12.sp
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Text(
                                            text = listOfWins.count{ it == 0 }.toString(),
                                            fontWeight = FontWeight.Bold,
                                            color = if (darkLight.value == 1) Color(255,245,166) else Color.White,
                                            fontSize = 24.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            counter.value = 0
                            for (b in 0..1) {
                                for (t in 0..<r.value * c.value) {
                                    playerPoints[b][t] = 0
                                }
                            }
                            backgroundColor.value = Color(0xFFED6A5E)
                            pointsTotal[0] = 0
                            pointsTotal[1] = 0
                            for (i in 0..1) {
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
                            showGridChangeDialog.value = false
                            optionsSeriesDialog.value = false
                            timedOrNot.value = false
                            displayChooseTime.value = false
                            if (chooseHandicap.value){
                                minsh1.value = ""
                                minsh2.value = ""
                                secsh1.value = ""
                                secsh2.value = ""
                                chooseHandicap.value = false
                            } else {
                                mins.value = ""
                                secs.value = ""
                            }
                            navController.popBackStack(Screen.HackerSettings.route, false)
                        },
                        modifier = Modifier
                            .width(275.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(132,105,199) else Color(87, 190, 235),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "New Series",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 25.sp
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
                            backgroundColor.value = if (darkLight.value == 1) Color(80,80,80) else Color(0xFFF2E6D1)
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
                            timedOrNot.value = false
                            displayChooseTime.value = false
                            showGridChangeDialog.value = false
                            optionsSeriesDialog.value = false
                            if (chooseHandicap.value){
                                minsh1.value = ""
                                minsh2.value = ""
                                secsh1.value = ""
                                secsh2.value = ""
                                chooseHandicap.value = false
                            } else {
                                mins.value = ""
                                secs.value = ""
                            }
                            navController.popBackStack(Screen.HomePage.route,false)
                        },
                        modifier = Modifier
                            .width(275.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(238,164,223) else Color(237,106,94),
                            contentColor = Color.White
                        )
                    ){
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DisplayWinner(navController = rememberNavController())
}