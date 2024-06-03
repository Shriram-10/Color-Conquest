package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun HighScorePage(navController: NavController, highScoreManager: HighScoreManager){
    var showNormalHS by remember { mutableStateOf(false)}
    var showHackerHS by remember { mutableStateOf(false)}
    var OGScreen by remember { mutableStateOf(true)}
    var CurrentHS : List<String> = highScoreManager.getData("name", "", "score", "", "mins", "", "secs", "")
    currentHSName.value = CurrentHS[0]
    if (CurrentHS[1] != ""){
        currentHS.value = CurrentHS[1].toInt()
    }
    if (CurrentHS[2] != ""){
        currentHSTime[0] = CurrentHS[2].toInt()
    }
    if (CurrentHS[3] != ""){
        currentHSTime[1] = CurrentHS[3].toInt()
    }
    if(causeDelay.value){
        LaunchedEffect(Unit) {
            OGScreen = false
            delay(400)
            showHackerHS = true
            causeDelay.value = false

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                if (darkLight.value == 1) Color.Black.copy(alpha = 0.5f) else Color.White.copy(
                    alpha = 0.5f
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .height(340.dp)
                .width(330.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(0xFF3E4171)
            ),
            shape = RoundedCornerShape(10)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(280.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ){
                    Text(
                        text = "HIGH SCORES",
                        color = Color.Black,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                AnimatedVisibility(
                    visible = OGScreen,
                    enter = slideInVertically() + fadeIn(),
                    exit = slideOutVertically() + fadeOut()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .height(50.dp),
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7)
                            )
                        ){
                            Text(
                                text = "Normal Mode",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        Button(
                            onClick = {
                                causeDelay.value = true
                            },
                            modifier = Modifier
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (darkLight.value == 1) Color(238,164,223) else Color(0xFFED6A5E)
                            ),
                            shape = RoundedCornerShape(20),
                        ){
                            Text(
                                text = "Hacker Mode",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (darkLight.value == 1) Color.Black else Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(28.dp))

                        Button(
                            onClick = {
                                displayHS.value = false
                            },
                            modifier = Modifier
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7)
                            )
                        ){
                            Text(
                                text = "HOME",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        }
                    }
                }

                AnimatedVisibility(
                    visible = showHackerHS,
                    enter = fadeIn(),
                    exit = fadeOut()
                    ) {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .height(235.dp)
                            .width(280.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkLight.value == 1) Color(195,189,215) else Color(0xFFC7F1FD)
                        ),
                        shape = RoundedCornerShape(10)
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .height(220.dp)
                                .width(250.dp)
                        ){
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (darkLight.value == 1) Color.Black else Color(32,79,151)
                                ),
                            ){
                                Text(
                                    textAlign = TextAlign.Center,
                                    text = "TIMED HACKER MODE",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ){
                                Row{
                                    Text(
                                        text = "Player Name : ",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = if (currentHSName.value == "") "" else currentHSName.value,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Row{
                                    Text(
                                        text = "Score : ",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = if (currentHS.value == 0) "" else currentHS.value.toString(),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Row{
                                    Text(
                                        text = "Time Taken : ",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = if (currentHSTime[0] == 0 && currentHSTime[1] == 0) "" else displayString(currentHSTime[0].toString(), currentHSTime[1].toString()),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(28.dp))

                            Button(
                                onClick = {
                                    showHackerHS = false
                                    OGScreen = true
                                },
                                modifier = Modifier
                                    .height(35.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7)
                                )
                            ){
                                Text(
                                    text = "OK",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HighScorePagePreview(){
    HighScorePage(navController = rememberNavController(), highScoreManager = HighScoreManager(LocalContext.current))
}