package com.example.task1colourconquest

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.task1colourconquest.Screen.GamePage.route
import com.example.task1colourconquest.ui.theme.fontFamily2

@Composable
fun ModesPage(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground(
                    isVerticalGradient = true,
                    colors = gradientColorList[darkLight.value]
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        val infiniteTransition = rememberInfiniteTransition()

        val colors = infiniteTransition.animateColor(
            if (darkLight.value == 1) Color(185,126,189) else Color(0xFFED6A5E),
            if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
            animationSpec = infiniteRepeatable(tween(200),
                repeatMode = RepeatMode.Reverse
            )
        ).value

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
                containerColor = colors
            )
        ){
            Text(
                text = "Choose Mode to Play",
                fontFamily = fontFamily2,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Button(
            onClick = {
                mode.value = 1
                navController.navigate(route = Screen.PlayerInformation.route)
            },
            modifier = Modifier
                .height(72.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
                contentColor = Color.LightGray
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            )
        ){
            Text(
                text = "NORMAL MODE",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                mode.value = 2
                navController.navigate(route = Screen.HackerSettings.route)
            },
            modifier = Modifier
                .height(72.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(185,126,189) else Color(0xFFED6A5E),
                contentColor = Color.DarkGray
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            )
        ){
            Text(
                text = "HACKER MODE",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(72.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (darkLight.value == 1) Color(130,112,167) else Color(0xFF0FA6F7),
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            )
        ){
            Text(
                text = "HACKER MODE ++",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModesPagePreview(){
    ModesPage(navController = rememberNavController())
}
