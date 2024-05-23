package com.example.task1colourconquest

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PlayerPage(navController: NavController) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground(
                    colors = gradientColorList,
                    isVerticalGradient = true
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(56.dp))

        Button(
            onClick = {  },
            shape = CutCornerShape(
                topStartPercent = 45,
                topEndPercent = 45,
                bottomStartPercent = 45,
                bottomEndPercent = 45),
            modifier = Modifier
                .width(330.dp)
                .height(56.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            ),
            border = BorderStroke(3.dp, Color(0xFFDABA9F)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF8D8BC)
            )
        ) {
            Text(
                text = "PLAYER INFORMATION",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(22.dp))
            Column(
                modifier = Modifier
                    .width(175.dp)
                    .height(245.dp)
            ){
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.playercard),
                        contentDescription = "Player Cards",
                        modifier = Modifier.aspectRatio(7f/10f)
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .width(175.dp)
                    .height(245.dp)
            ){
                Spacer(modifier = Modifier.height(22.dp))
                Card(modifier = Modifier
                    .width(175.dp)
                    .height(96.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 16.dp
                    ),
                    shape = RoundedCornerShape(
                        topStartPercent = 30,
                        topEndPercent = 30,
                        bottomStartPercent = 30,
                        bottomEndPercent = 30),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF3E4171)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .height(56.dp)
                    ){
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Person",
                            tint = Color(0xFFED6A5E),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    BasicTextField(
                        value = player1Name.value,
                        onValueChange = {player1Name.value = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        cursorBrush = SolidColor(Color(0xFFED6A5E)),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFED6A5E),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.sp
                        )
                    )

                    Text(
                        text = "------------",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                Card(modifier = Modifier
                    .width(175.dp)
                    .height(96.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 16.dp
                    ),
                    shape = RoundedCornerShape(
                        topStartPercent = 30,
                        topEndPercent = 30,
                        bottomStartPercent = 30,
                        bottomEndPercent = 30),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF3E4171)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .height(56.dp)
                    ){
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Person",
                            tint = Color(0xFF0FA6F7),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    BasicTextField(
                        value = player2Name.value,
                        onValueChange = {player2Name.value = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        cursorBrush = SolidColor(Color(0xFF0FA6F7)),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0FA6F7),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.sp
                        )
                    )
                    Text(
                        text = "------------",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF0FA6F7)
                    )
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.players),
            contentDescription = "players"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(Screen.GamePage.route)
            },
            modifier = Modifier
                .width(164.dp)
                .height(64.dp),
            enabled = true,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0FA6F7)
            )
        ){
            Text(
                text = "START",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerPagePreview(){
    PlayerPage(navController = rememberNavController())
}