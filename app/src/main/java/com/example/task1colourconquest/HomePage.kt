package com.example.task1colourconquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.task1colourconquest.ui.theme.fontFamily

@Composable
fun HomePage(navController: NavController) {

    var enterGame by remember { mutableStateOf(false) }

    if (enterGame) {
        AlertDialog(
            onDismissRequest = { enterGame = false },
            confirmButton = {
                Button(
                    onClick = { enterGame = false },
                    modifier = Modifier
                        .width(88.dp)
                        .height(48.dp),
                    enabled = true,
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 4.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFED6A5E)
                    ),
                    shape = RoundedCornerShape(topStartPercent = 30,
                        bottomEndPercent = 30)
                ) {
                    Text(text = "OK")
                }
            },
            title = {
                Text(text = "How to Play?",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFED6A5E)
                )
            },
            text = {
                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam hendrerit eros at velit vulputate, at sagittis diam pulvinar. Ut sagittis semper orci, fermentum iaculis dui aliquet at. Aenean ut auctor quam. Vivamus lobortis sapien ante, sed suscipit sem consequat id. Maecenas rhoncus, mi quis consequat convallis, tortor lorem bibendum lectus, a congue arcu diam in velit. Fusce in tortor pretium, scelerisque mauris nec, pellentesque odio. Phasellus semper ipsum nec diam egestas, at pretium ante elementum. Donec pulvinar, erat et faucibus interdum, nisl lorem ornare tortor, id suscipit erat est vitae ante. Quisque vel ex aliquet, eleifend augue non, fringilla diam. Phasellus vulputate turpis urna, non gravida nulla rhoncus a. Fusce faucibus nisl nec nibh blandit dignissim. Sed vestibulum, ante at pharetra vestibulum, est mauris pretium ex, vitae posuere sem ante sed turpis. Fusce maximus efficitur mauris at congue. Suspendisse vel suscipit purus, vel ultrices lorem.")
            }
        )
    }

    Column (
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
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "COLOR",
            style = TextStyle(brush = Brush.verticalGradient(colors = gradientColorList2)),
            fontFamily = fontFamily,
            fontSize = 64.sp,
            color = Color.Black
        )

        Text(
            text = "CONQUEST",
            style = TextStyle(brush = Brush.verticalGradient(colors = gradientColorList3)),
            fontFamily = fontFamily,
            fontSize = 64.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(100.dp))

        Image(painter = painterResource(id = R.drawable.players),
            contentDescription = "Players")

        Spacer(modifier = Modifier.height(100.dp))

        Row {
            Button(
                modifier = Modifier
                    .height(64.dp)
                    .width(144.dp),
                enabled = true,
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp,
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0FA6F7)
                ),
                onClick = {
                    navController.navigate(Screen.PlayerInformation.route)
                },
                shape = RoundedCornerShape(
                    topStartPercent = 50,
                    topEndPercent = 50,
                    bottomStartPercent = 50,
                    bottomEndPercent = 50
                )
            ) {
                Text(text = "PLAY",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 24.sp)
            }

            Button(
                onClick = {
                    enterGame = true
                },
                modifier = Modifier
                    .padding(
                        start = 75.dp,
                        top = 4.dp,
                        end = 0.dp
                    )
                    .height(56.dp)
                    .width(56.dp),
                enabled = true,
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 12.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3C4271)
                )
            ) {
                Text(text = "?",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 24.sp)
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        Text(text = "Made with \uD83D\uDC9A by Shriram Umapathy")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    HomePage(navController = NavController(LocalContext.current))
}