package com.example.task1colourconquest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HighScorePage(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (darkLight.value == 1) Color.Black.copy(alpha = 0.5f) else Color.White.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .height(340.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color(0xFF3E4171)
            ),
            shape = RoundedCornerShape(10)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(250.dp)
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

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(10),
                ){

                }

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(10),
                ){

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HighScorePagePreview(){
    HighScorePage(navController = rememberNavController())
}