package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
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
        var chooseMultiplayer by remember { mutableStateOf(false) }
        var chooseBot by remember {mutableStateOf(false) }
        var selectNoOfPlayers by remember { mutableStateOf(false) }
        var choosePlayersDialog by remember { mutableStateOf(true) }
        var chooseColorsDialog by remember { mutableStateOf(true) }
        var selectColors by remember { mutableStateOf(false) }

        var showNote1 by remember { mutableStateOf(false) }
        var showNote2 by remember { mutableStateOf(false) }
        var showNote3 by remember { mutableStateOf(false) }

        if (showNote1){
            AlertDialog(
                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color.White,
                onDismissRequest = {  },
                confirmButton = {
                    Button(
                        onClick = { showNote1 = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 0,
                            bottomStartPercent = 0,
                            bottomEndPercent = 20
                        )
                    ) {
                        Text(text = "OK")
                    }
                },
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "NOTE",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                },
                text = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "5 Player mode is only available on grid sizes 7 × 7 and above. ",
                        fontSize = 18.sp,
                        color = if (darkLight.value == 1) Color.White else Color.Black
                    )
                }
            )
        }

        if (showNote2){
            AlertDialog(
                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color.White,
                onDismissRequest = {  },
                confirmButton = {
                    Button(
                        onClick = { showNote2 = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 0,
                            bottomStartPercent = 0,
                            bottomEndPercent = 20
                        )
                    ) {
                        Text(text = "OK")
                    }
                },
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "NOTE",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                },
                text = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "4 Player mode is only available on grid sizes 5 × 5 and above. ",
                        fontSize = 18.sp,
                        color = if (darkLight.value == 1) Color.White else Color.Black
                    )
                }
            )
        }

        if (showNote3){
            AlertDialog(
                containerColor = if (darkLight.value == 1) Color(64,64,64) else Color.White,
                onDismissRequest = {  },
                confirmButton = {
                    Button(
                        onClick = { showNote3 = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(
                            topStartPercent = 20,
                            topEndPercent = 0,
                            bottomStartPercent = 0,
                            bottomEndPercent = 20
                        )
                    ) {
                        Text(text = "OK")
                    }
                },
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "NOTE",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                },
                text = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "2 Player mode is the default Player Mode.",
                        fontSize = 18.sp,
                        color = if (darkLight.value == 1) Color.White else Color.Black
                    )
                }
            )
        }

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

                    AnimatedVisibility(
                        visible = choosePlayersDialog
                    ){
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
                                        Row {
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
                                                    .width(50.dp)
                                                    .height(40.dp),
                                                shape = RoundedCornerShape(5)
                                            ) {
                                                Text(
                                                    text = "2",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Gray
                                                )
                                            }
                                            Box(
                                                contentAlignment = Alignment.Center
                                            ){
                                                Button(
                                                    onClick = {showNote3 = true},
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (darkLight.value == 1) Color(
                                                            237,
                                                            212,
                                                            224
                                                        ) else Color(0xFFF2D1CD),
                                                        contentColor = if (darkLight.value == 1) Color.LightGray else Color.Black
                                                    ),
                                                    modifier = Modifier
                                                        .width(50.dp)
                                                        .height(40.dp)
                                                ){

                                                }
                                                Icon(
                                                    Icons.Outlined.Info,
                                                    contentDescription = "Info",
                                                    tint = if (darkLight.value == 1) Color.LightGray else Color.Gray
                                                )
                                            }
                                        }

                                        Row {
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
                                                    .width(50.dp)
                                                    .height(40.dp),
                                                shape = RoundedCornerShape(5)
                                            ) {
                                                Text(
                                                    text = "3",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Gray
                                                )
                                            }
                                            Box(
                                                contentAlignment = Alignment.Center
                                            ){
                                                Button(
                                                    onClick = {},
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (darkLight.value == 1) Color(
                                                            237,
                                                            212,
                                                            224
                                                        ) else Color(0xFFF2D1CD),
                                                        contentColor = if (darkLight.value == 1) Color.LightGray else Color.Black
                                                    ),
                                                    modifier = Modifier
                                                        .width(50.dp)
                                                        .height(40.dp)
                                                ){

                                                }
                                            }
                                        }

                                        Row {
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
                                                    .width(50.dp)
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
                                            Box(
                                                contentAlignment = Alignment.Center
                                            ){
                                                Button(
                                                    onClick = {
                                                        showNote2 = true
                                                    },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (darkLight.value == 1) Color(
                                                            237,
                                                            212,
                                                            224
                                                        ) else Color(0xFFF2D1CD),
                                                        contentColor = if (darkLight.value == 1) Color.LightGray else Color.Black
                                                    ),
                                                    modifier = Modifier
                                                        .width(50.dp)
                                                        .height(40.dp)
                                                ){

                                                }
                                                Icon(
                                                    Icons.Outlined.Info,
                                                    contentDescription = "Info",
                                                    tint = if (darkLight.value == 1) Color.LightGray else Color.Gray
                                                )
                                            }
                                        }

                                        Row{
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
                                                    .width(50.dp)
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
                                            Box(
                                                contentAlignment = Alignment.Center
                                            ){
                                                Button(
                                                    onClick = {
                                                        showNote1 = true
                                                    },
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (darkLight.value == 1) Color(
                                                            237,
                                                            212,
                                                            224
                                                        ) else Color(0xFFF2D1CD),
                                                        contentColor = if (darkLight.value == 1) Color.LightGray else Color.Black
                                                    ),
                                                    modifier = Modifier
                                                        .width(50.dp)
                                                        .height(40.dp)
                                                ){

                                                }
                                                Icon(
                                                    Icons.Outlined.Info,
                                                    contentDescription = "Info",
                                                    tint = if (darkLight.value == 1) Color.LightGray else Color.Gray
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Canvas(
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ){
                        drawLine(
                            color = if (darkLight.value == 1) Color.White else Color.Black,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 2f
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    AnimatedVisibility(
                        visible = chooseColorsDialog && noOfPlayers.value > 2
                    ) {
                        Button(
                            onClick = {
                                choosePlayersDialog = !choosePlayersDialog
                                selectColors = !selectColors
                            },
                            modifier = Modifier
                                .height(44.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (darkLight.value == 1) Color(
                                    130,
                                    112,
                                    167
                                ) else Color(0xFF0FA6F7),
                            )
                        ) {
                            Text(
                                text = "Choose Color",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Column{
                            AnimatedVisibility(
                                visible = selectColors
                            ) {
                                Spacer(modifier = Modifier.height(16.dp))

                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .offset(0.dp, 60.dp)
                                        .height(210.dp)
                                        .background(
                                            if (darkLight.value == 1) Color(
                                                237,
                                                212,
                                                224
                                            ) else Color(0xFFF2D1CD)
                                        ),
                                    contentPadding = PaddingValues(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    reverseLayout = false,
                                    state = rememberLazyListState(),
                                    userScrollEnabled = true,
                                    content = {
                                        items(noOfPlayers.value - 2){
                                            Column(
                                                /*modifier = Modifier.fillMaxSize(),*/
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ){

                                            }
                                        }
                                    }
                                )
                            }
                        }
                    }
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