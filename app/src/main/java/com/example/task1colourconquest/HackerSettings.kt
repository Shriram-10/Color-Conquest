package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HackerSettings(navController: NavController){

    var isTimerVisible by remember {mutableStateOf(false)}
    var isSeriesVisible by remember {mutableStateOf(false)}
    var displayString = ""

    if (showWarning1.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning1.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Enter an Integer",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nMinutes should not exceed 15.\nSeconds should not exceed 59.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }

    if (showWarning2.value) {
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning2.value = false },
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
                    text = "Input Should be Within Limits",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFED6A5E)
                )
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nMinutes should not exceed 15.\nSeconds should not exceed 59.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }

    if (showWarning3.value) {
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning3.value = false },
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
                    text = "Input Should be Within Limits",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFED6A5E)
                )
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nPlease enter a valid time.\nMinutes and seconds should be greater than zero.\nMinutes should not exceed 15.\nSeconds should not exceed 59.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning4.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning4.value = false },
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
                    text = "Enter Time to Enter!",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFED6A5E)
                )
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nPlease enter a valid time.\nMinutes and seconds should be greater than zero.\nMinutes should not exceed 15.\nSeconds should not exceed 59.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning5.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning5.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Enter an Integer!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of rows and columns should not exceed 10 and should be greater than 2.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning10.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning10.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Enter an Integer!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of matches should be greater than 1 and should not exceed 10.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning6.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning6.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Grid Size too Small!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of rows and columns should be greater than 2.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning11.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning11.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Not Enough Matches!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nAt least two matches are required in a series.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning7.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning7.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Grid Size too Large!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of rows and columns should not exceed 10.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning12.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning12.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Too many matches!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of matches should not exceed 10.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning8.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning8.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Enter Input!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of rows and columns should be greater than 2 and should not exceed 10.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning13.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning13.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Enter Input!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "NOTE:\nNumber of matches should be greater than 1 and should not exceed 10.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }
    if (showWarning9.value){
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Button(
                    onClick = { showWarning9.value = false },
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Enter Positive Integer!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFED6A5E)
                    )
                }
            },
            text = {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Recieved Input is negative!\nNOTE:\nNumber of rows and columns should be greater than 2 and should not exceed 10.",
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }
        )
    }

    Column(
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
    ){
        AnimatedVisibility(
            visible = isSeriesVisible,
            enter = slideIn(
                initialOffset = {fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = slideOut(
                targetOffset = {fullSize -> IntOffset( -fullSize.width,0) },
                animationSpec = tween(durationMillis = 1000)
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
                    containerColor = Color(0xFFF2E6D1)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp,
                    pressedElevation = 12.dp
                ),
                shape = RoundedCornerShape(5)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    AnimatedVisibility(visible = !optionsSeriesDialog.value) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Button(
                                onClick = {
                                    setCustomGrid.value = !setCustomGrid.value
                                    changeGridSize.value = false
                                    showGridChangeDialog.value = false
                                    r.value = 0
                                    c.value = 0
                                },
                                modifier = Modifier.height(48.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF0FA6F7)
                                ),
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 12.dp
                                ),
                            ){
                                Text(
                                    text = "Custom Grid" ,
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            AnimatedVisibility(visible = setCustomGrid.value) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Set Grid Size : ",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                        Button(
                                            onClick = {
                                                showGridChangeDialog.value =
                                                    !showGridChangeDialog.value
                                            },
                                            modifier = Modifier.height(44.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFFED6A5E)
                                            ),
                                            shape = RoundedCornerShape(15),
                                            elevation = ButtonDefaults.buttonElevation(
                                                defaultElevation = 12.dp
                                            ),
                                        ) {
                                            Text(
                                                text = if ((r.value.toString() == "0" && c.value.toString() == "0") && !changeGridSize.value) "Set" else r.value.toString() + " × " + c.value.toString(),
                                                color = Color.White,
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                        Spacer(modifier = Modifier.height(20.dp))
                                        AnimatedVisibility(
                                            visible = showGridChangeDialog.value,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color(0xFFF2D1CD))
                                                .clip(RoundedCornerShape(20))
                                        ) {
                                            Column(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                            ) {
                                                Spacer(modifier = Modifier.height(5.dp))
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                ) {
                                                    Spacer(modifier = Modifier.width(55.dp))
                                                    Text(
                                                        text = "Rows",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color.Black
                                                    )
                                                    Spacer(modifier = Modifier.width(30.dp))

                                                    Text(
                                                        text = "Columns",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color.Black
                                                    )
                                                }
                                                Row(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(80.dp),
                                                    horizontalArrangement = Arrangement.Center,
                                                    verticalAlignment = Alignment.CenterVertically,
                                                ) {
                                                    Text(
                                                        text = " Size : ",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color.Black
                                                    )
                                                    OutlinedTextField(
                                                        value = rInput.value,
                                                        onValueChange = {
                                                            rInput.value = it
                                                        },
                                                        keyboardOptions = KeyboardOptions(
                                                            keyboardType = KeyboardType.Number
                                                        ),
                                                        modifier = Modifier
                                                            .height(48.dp)
                                                            .width(60.dp)
                                                            .background(Color(0xFFC7F1FD)),
                                                    )
                                                    Text(
                                                        text = " × ",
                                                        fontSize = 18.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color.Black
                                                    )

                                                    OutlinedTextField(
                                                        value = cInput.value,
                                                        onValueChange = {
                                                            cInput.value = it
                                                        },
                                                        keyboardOptions = KeyboardOptions(
                                                            keyboardType = KeyboardType.Number
                                                        ),
                                                        modifier = Modifier
                                                            .height(48.dp)
                                                            .width(60.dp)
                                                            .background(Color(0xFFC7F1FD)),
                                                    )
                                                }
                                                Row(
                                                    horizontalArrangement = Arrangement.Center
                                                ) {
                                                    Button(
                                                        onClick = {
                                                            if (rInput.value == "" || cInput.value == "") {
                                                                showWarning8.value = true
                                                            } else {
                                                                if (rInput.value.contains(",") || cInput.value.contains(",") || rInput.value.contains(".") || cInput.value.contains(".")) {
                                                                    showWarning5.value = true
                                                                    rInput.value = ""
                                                                    cInput.value = ""
                                                                } else if (rInput.value.contains(" ")) {
                                                                    rInput.value =
                                                                        mins.value.replace(" ", "")
                                                                } else if (cInput.value.contains(" ")) {
                                                                    cInput.value =
                                                                        cInput.value.replace(
                                                                            " ",
                                                                            ""
                                                                        )
                                                                } else if (rInput.value.toInt() < 0 || cInput.value.toInt() < 0) {
                                                                    showWarning9.value = true
                                                                    rInput.value = ""
                                                                    cInput.value = ""
                                                                } else if (rInput.value.toInt() < 3 || cInput.value.toInt() < 3) {
                                                                    showWarning6.value = true
                                                                    rInput.value = ""
                                                                    cInput.value = ""
                                                                } else if (rInput.value.toInt() > 10 || cInput.value.toInt() > 10) {
                                                                    showWarning7.value = true
                                                                    rInput.value = ""
                                                                    cInput.value = ""
                                                                }
                                                            }
                                                            showGridChangeDialog.value = false
                                                            if (rInput.value != "" && cInput.value != "" && !showGridChangeDialog.value && !changeGridSize.value) {
                                                                r.value = rInput.value.toInt()
                                                                c.value = cInput.value.toInt()
                                                                generateGridSizeList(
                                                                    r.value,
                                                                    c.value
                                                                )
                                                            }
                                                        },
                                                        modifier = Modifier.height(40.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = Color(0xFF0FA6F7)
                                                        ),
                                                        elevation = ButtonDefaults.buttonElevation(
                                                            defaultElevation = 12.dp
                                                        ),
                                                        shape = RoundedCornerShape(15)
                                                    ) {
                                                        Text(
                                                            text = "Confirm",
                                                            fontSize = 16.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.White
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.width(20.dp))
                                                    Button(
                                                        onClick = {
                                                            changeGridSize.value = false
                                                            r.value = 0
                                                            c.value = 0
                                                            rInput.value = ""
                                                            cInput.value = ""
                                                            showGridChangeDialog.value = false
                                                        },
                                                        modifier = Modifier.height(40.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = Color(0xFF0FA6F7)
                                                        ),
                                                        elevation = ButtonDefaults.buttonElevation(
                                                            defaultElevation = 12.dp
                                                        ),
                                                        shape = RoundedCornerShape(15)
                                                    ) {
                                                        Text(
                                                            text = "Cancel",
                                                            fontSize = 16.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                                Spacer(modifier = Modifier.height(10.dp))
                                            }
                                    }
                                }
                            }
                        }
                    }
                    Text(
                        text = "-----------------",
                        fontSize = 44.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
//                    Spacer(modifier = Modifier.height(40.dp))
                    AnimatedVisibility(visible = true) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {
                                    showGridChangeDialog.value = false
                                    optionsSeriesDialog.value = !optionsSeriesDialog.value
                                },
                                modifier = Modifier.height(48.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF0FA6F7)
                                ),
                                elevation = ButtonDefaults.buttonElevation(
                                    defaultElevation = 12.dp
                                )
                            ){
                                Text(
                                    text = "Series Mode",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            AnimatedVisibility(visible = optionsSeriesDialog.value) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Text(
                                            text = "Handicapped Series? : ",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Button(
                                            onClick = {
                                                chooseSeriesHandicap.value =
                                                    !chooseSeriesHandicap.value
                                            },
                                            modifier = Modifier.height(44.dp),
                                            shape = RoundedCornerShape(15),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFFED6A5E),
                                                contentColor = Color.White
                                            )
                                        ){
                                           Text(
                                               text = if(chooseSeriesHandicap.value) "YES" else "NO",
                                               fontSize = 18.sp,
                                               fontWeight = FontWeight.Bold,
                                               color = Color.White
                                           )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = "Choose number of matches : ",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Button(
                                            onClick = {
                                                noOfMatches.value = 3
                                            },
                                            modifier = Modifier.height(56.dp),
                                            shape = RoundedCornerShape(15),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = if (noOfMatches.value == 3) Color(0xFF0FA6F7)  else Color(0xFFED6A5E),
                                            )
                                        ){
                                            Text(
                                                text = " 3 ",
                                                fontSize = 26.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Button(
                                            onClick = {
                                                noOfMatches.value = 5
                                            },
                                            modifier = Modifier.height(56.dp),
                                            shape = RoundedCornerShape(15),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = if (noOfMatches.value == 5) Color(0xFF0FA6F7) else Color(0xFFED6A5E)
                                                )
                                        ){
                                            Text(
                                                text = " 5 ",
                                                fontSize = 26.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        AnimatedVisibility(visible = customSeries.value) {
                                            Button(
                                                onClick = {
                                                    customSeries.value = false
                                                },
                                                modifier = Modifier.height(56.dp),
                                                shape = RoundedCornerShape(15),
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = Color(0xFFED6A5E),
                                                    contentColor = Color.White
                                                )
                                            ){
                                                Text(
                                                    text = "Custom",
                                                    fontSize = 22.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White
                                                )
                                            }
                                        }
                                        AnimatedVisibility(visible = !customSeries.value) {
                                            OutlinedTextField(
                                                value = noOfMatchesInput.value,
                                                onValueChange = {
                                                    noOfMatchesInput.value = it
                                                },
                                                modifier = Modifier
                                                    .width(64.dp)
                                                    .height(56.dp)
                                                    .background(Color(0xFFF2D1CD)),
                                                keyboardOptions = KeyboardOptions(
                                                    keyboardType = KeyboardType.Number
                                                )
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Button(
                                        onClick = {
                                            if (noOfMatchesInput.value == ""){
                                                showWarning13.value = true
                                            } else {
                                                if (noOfMatchesInput.value.contains(",") || noOfMatchesInput.value.contains(".")){
                                                    showWarning10.value = true
                                                } else if (noOfMatchesInput.value.contains(" ")){
                                                    noOfMatchesInput.value = noOfMatchesInput.value.replace(" ", "")
                                                } else if (noOfMatchesInput.value.toInt() <= 1){
                                                    showWarning11.value = true
                                                } else if (noOfMatchesInput.value.toInt() > 10){
                                                    showWarning12.value = true
                                                } else {
                                                    noOfMatches.value = noOfMatchesInput.value.toInt()
                                                }
                                            }
                                        },
                                        modifier = Modifier.height(44.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color(0xFF0FA6F7)
                                        ),
                                        elevation = ButtonDefaults.buttonElevation(
                                            defaultElevation = 12.dp
                                        ),
                                    ){
                                        Text(
                                            text = "Confirm",
                                            color = Color.White,
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.ExtraBold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if(isTimerVisible){
                    isTimerVisible = false
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                        isSeriesVisible = !isSeriesVisible
                    }
                } else {
                    isSeriesVisible = !isSeriesVisible
                }
            }
                ,
            modifier = Modifier.height(70.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED6A5E)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(20)
        ){
            Text(
                text = "Series Settings",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (isSeriesVisible){
                    isSeriesVisible = false
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2000)
                        isTimerVisible = !isTimerVisible
                    }
                } else {
                    isTimerVisible = !isTimerVisible
                }
            },
            modifier = Modifier.height(70.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFED6A5E)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(20)
        ){
            Text(
                text = "Timer Settings",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = isTimerVisible,
            enter = slideIn(
                initialOffset = {fullSize -> IntOffset(fullSize.width, 0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = slideOut(
                targetOffset = {fullSize -> IntOffset( -fullSize.width,0) },
                animationSpec = tween(durationMillis = 1000)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(0.9f)
                .clip(RoundedCornerShape(5))
        ) {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF2E6D1)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 25.dp,
                    pressedElevation = 12.dp
                ),
                shape = RoundedCornerShape(5)
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Spacer(modifier = Modifier.height(20.dp))
                    AnimatedVisibility(visible = true) {
                        Button(
                            onClick = {
                                timedOrNot.value = !timedOrNot.value
                                displayChooseTime.value = !displayChooseTime.value
                                if (chooseHandicap.value){
                                    chooseHandicap.value = false
                                }
                                mins.value = ""
                                secs.value = ""
                                minsh1.value = ""
                                secsh1.value = ""
                                minsh2.value = ""
                                secsh2.value = ""
                                showDropDown.value = false
                            },
                            modifier = Modifier.height(44.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF0FA6F7)
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 12.dp
                            ),
                        ){
                            Text(
                                text = if(timedOrNot.value) "Timed" else "Not Timed" ,
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    AnimatedVisibility(
                        visible = displayChooseTime.value
                    ) {
                        Column{
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = "Handicapped Match? : ",
                                    fontSize = 18.sp,
                                    color = Color.DarkGray,
                                    fontWeight = FontWeight.Bold
                                )
                                Button(
                                    onClick = {
                                        chooseHandicap.value = !chooseHandicap.value
                                        if(chooseHandicap.value){
                                            showDropDown.value = false
                                            mins.value = ""
                                            secs.value = ""
                                        }
                                    },
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(96.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF0FA6F7),
                                        contentColor = Color(0xFFF2E6D1)
                                    ),
                                    elevation = ButtonDefaults.buttonElevation(
                                        defaultElevation = 8.dp
                                    ),
                                    shape = RoundedCornerShape(15)
                                ){
                                    Text(
                                        text = if(chooseHandicap.value) "YES" else "NO",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            AnimatedVisibility(
                                visible = !chooseHandicap.value
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ){
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        Text(
                                            text = "Time in minutes : ",
                                            fontSize = 18.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )

                                        Column(
                                            modifier = Modifier
                                                .height(IntrinsicSize.Max)
                                                .clip(RoundedCornerShape(10))
                                        ){
                                            Button(
                                                onClick = {
                                                    showDropDown.value = !showDropDown.value
                                                    if (showTimerDialog.value){
                                                        showTimerDialog.value = false
                                                    }
                                                },
                                                modifier = Modifier
                                                    .height(40.dp)
                                                    .width(IntrinsicSize.Max),
                                                shape = RoundedCornerShape(5),
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = Color(0xFFED6A5E)
                                                )
                                            ){
                                                Text(
                                                    text = if(mins.value == "" && secs.value == "" || displayString == "") "Select " else displayString,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White,
                                                    fontSize = 18.sp
                                                )
                                            }
                                            AnimatedVisibility(
                                                visible = showDropDown.value,
                                                modifier = Modifier
                                                    .width(IntrinsicSize.Max)
                                                    .height(IntrinsicSize.Max)
                                            ){
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .weight(1f)
                                                        .background(Color(0xFFF2D1CD))
                                                        .clip(RoundedCornerShape(20))
                                                ){
                                                    Button(
                                                        onClick = {
                                                            mins.value = "1"
                                                            secs.value = "0"
                                                            showDropDown.value = false
                                                            displayString = displayString(mins.value, secs.value)
                                                        },
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = Color(0xFFF2D1CD)
                                                        ),
                                                        modifier = Modifier.height(40.dp),
                                                        shape = RoundedCornerShape(5)
                                                    ){
                                                        Text(
                                                            text = " 1 Min ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.Gray
                                                        )
                                                    }

                                                    Button(
                                                        onClick = {
                                                            mins.value = "2"
                                                            secs.value = "0"
                                                            showDropDown.value = false
                                                            displayString = displayString(mins.value, secs.value)
                                                        },
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = Color(0xFFF2D1CD)
                                                        ),
                                                        modifier = Modifier.height(40.dp),
                                                        shape = RoundedCornerShape(5)
                                                    ){
                                                        Text(
                                                            text = " 2 Min ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.Gray
                                                        )
                                                    }
                                                    Button(
                                                        onClick = {
                                                            mins.value = "3"
                                                            secs.value = "0"
                                                            showDropDown.value = false
                                                            displayString = displayString(mins.value, secs.value)
                                                        },
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = Color(0xFFF2D1CD)
                                                        ),
                                                        modifier = Modifier.height(40.dp),
                                                        shape = RoundedCornerShape(5),
                                                    ){
                                                        Text(
                                                            text = " 3 Min ",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.Gray
                                                        )
                                                    }
                                                    Box(
                                                        modifier = Modifier.fillMaxSize(),
                                                        contentAlignment = Alignment.Center
                                                    ){
                                                        Button(
                                                            onClick = {
                                                                showDropDown.value = false
                                                                showTimerDialog.value = true
                                                            },
                                                            colors = ButtonDefaults.buttonColors(
                                                                containerColor = Color(0xFFF2D1CD)
                                                            ),
                                                            modifier = Modifier.height(40.dp),
                                                            shape = RoundedCornerShape(5),
                                                        ){

                                                        }
                                                        Text(
                                                            textAlign = TextAlign.Center,
                                                            text = "Custom",
                                                            fontSize = 18.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.DarkGray
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(20.dp))

                                    AnimatedVisibility(
                                        visible = showTimerDialog.value,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(Color(0xFFF2D1CD))
                                            .clip(RoundedCornerShape(20))
                                    ){
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ){
                                            Spacer(modifier = Modifier.height(5.dp))
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth(),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                            ){
                                                Spacer(modifier = Modifier.width(55.dp))
                                                Text(
                                                    text = "Mins",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.width(30.dp))

                                                Text(
                                                    text = "Secs",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                            }
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(80.dp),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically,
                                            ){
                                                Text(
                                                    text = "Time : ",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                                OutlinedTextField(
                                                    value = mins.value,
                                                    onValueChange = {
                                                        mins.value = it
                                                    },
                                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                    modifier = Modifier
                                                        .height(48.dp)
                                                        .width(60.dp)
                                                        .background(Color(0xFFC7F1FD)),
                                                )
                                                Text(
                                                    text = " : ",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )

                                                OutlinedTextField(
                                                    value = secs.value,
                                                    onValueChange = {
                                                        secs.value = it
                                                    },
                                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                    modifier = Modifier
                                                        .height(48.dp)
                                                        .width(60.dp)
                                                        .background(Color(0xFFC7F1FD)),
                                                )
                                            }
                                            Button(
                                                onClick = {
                                                    if (mins.value == "" || secs.value == ""){
                                                        showWarning4.value = true
                                                    } else {
                                                        if (mins.value.contains(",") || secs.value.contains(",") || mins.value.contains(".") || secs.value.contains(".")){
                                                            showWarning1.value = true
                                                        } else if (mins.value.contains(" ")){
                                                            mins.value = mins.value.replace(" ", "")
                                                        } else if (secs.value.contains(" ")){
                                                            secs.value = secs.value.replace(" ", "")
                                                        } else if ((mins.value.toInt() < 0 || secs.value.toInt() < 0) || (mins.value.toInt() == 0 && secs.value.toInt() == 0)){
                                                            showWarning3.value = true
                                                        } else if (mins.value.toInt() > 15 || secs.value.toInt() > 59){
                                                            showWarning2.value = true
                                                        } else {
                                                            displayString = displayString(mins.value, secs.value)
                                                        }
                                                    }

                                                    showTimerDialog.value = false
                                                },
                                                modifier = Modifier.height(40.dp),
                                                colors = ButtonDefaults.buttonColors(
                                                    containerColor = Color(0xFF0FA6F7)
                                                ),
                                                elevation = ButtonDefaults.buttonElevation(
                                                    defaultElevation = 12.dp
                                                ),
                                                shape = RoundedCornerShape(15)
                                            ){
                                                Text(
                                                    text = "Confirm",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(20.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                    AnimatedVisibility(
                        visible = chooseHandicap.value
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                AnimatedVisibility(
                                    visible = chooseHandicap.value,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color(0xFFF2D1CD))
                                        .clip(RoundedCornerShape(20))
                                ){
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                    ){
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                        ){
                                            Spacer(modifier = Modifier.width(55.dp))
                                            Text(
                                                text = "Mins",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                            )
                                            Spacer(modifier = Modifier.width(30.dp))

                                            Text(
                                                text = "Secs",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                            )
                                        }
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(60.dp),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                        ){
                                            Text(
                                                text = "Player 1 : ",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                            )
                                            OutlinedTextField(
                                                value = minsh1.value,
                                                onValueChange = {
                                                    minsh1.value = it
                                                },
                                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                modifier = Modifier
                                                    .height(48.dp)
                                                    .width(60.dp)
                                                    .background(Color(0xFFC7F1FD)),
                                            )
                                            Text(
                                                text = " : ",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                            )

                                            OutlinedTextField(
                                                value = secsh1.value,
                                                onValueChange = {
                                                    secsh1.value = it
                                                },
                                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                modifier = Modifier
                                                    .height(48.dp)
                                                    .width(60.dp)
                                                    .background(Color(0xFFC7F1FD)),
                                            )
                                        }
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(60.dp),
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                        ){
                                            Text(
                                                text = "Player 2 : ",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                            )
                                            OutlinedTextField(
                                                value = minsh2.value,
                                                onValueChange = {
                                                    minsh2.value = it
                                                },
                                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                modifier = Modifier
                                                    .height(48.dp)
                                                    .width(60.dp)
                                                    .background(Color(0xFFC7F1FD)),
                                            )
                                            Text(
                                                text = " : ",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.Black
                                            )

                                            OutlinedTextField(
                                                value = secsh2.value,
                                                onValueChange = {
                                                    secsh2.value = it
                                                },
                                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                modifier = Modifier
                                                    .height(48.dp)
                                                    .width(60.dp)
                                                    .background(Color(0xFFC7F1FD)),
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(16.dp))

                                        Button(
                                            onClick = {
                                                if (minsh1.value == "" || secsh1.value == "" || minsh2.value == "" || secsh2.value == ""){
                                                    showWarning4.value = true
                                                } else {
                                                    if (minsh1.value.contains(",") || secsh1.value.contains(",") || secsh2.value.contains(",") || minsh2.value.contains(",") || minsh1.value.contains(".") || minsh2.value.contains(".") || secsh1.value.contains(".") || secsh2.value.contains(".")){
                                                        showWarning1.value = true
                                                    } else if (minsh1.value.contains(" ")){
                                                        minsh1.value = minsh1.value.replace(" ", "")
                                                    } else if (minsh2.value.contains(" ")){
                                                        minsh2.value = minsh2.value.replace(" ", "")
                                                    } else if (secsh1.value.contains(" ")){
                                                        secsh1.value = secsh1.value.replace(" ", "")
                                                    } else if (secsh2.value.contains(" ")){
                                                        secsh2.value = secsh2.value.replace(" ", "")
                                                    } else if (((minsh1.value.toInt() < 0 && secsh1.value.toInt() <= 0) && (minsh1.value.toInt() <= 0 && secsh1.value.toInt() < 0)) || ((minsh2.value.toInt() < 0 && secsh2.value.toInt() <= 0) && (minsh2.value.toInt() <= 0 && secsh2.value.toInt() < 0))){
                                                        showWarning3.value = true
                                                    } else if (minsh1.value.toInt() > 15 || secsh1.value.toInt() > 59 || minsh2.value.toInt() > 15 || secsh2.value.toInt() > 59){
                                                        showWarning2.value = true
                                                    }
                                                }
                                            },
                                            modifier = Modifier.height(40.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFF0FA6F7)
                                            ),
                                            elevation = ButtonDefaults.buttonElevation(
                                                defaultElevation = 12.dp
                                            ),
                                            shape = RoundedCornerShape(15)
                                        ){
                                            Text(
                                                text = "Confirm",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(20.dp))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (timedOrNot.value){
                    if (!chooseHandicap.value){
                        if (mins.value == "" || secs.value == ""){
                            showWarning4.value = true
                        } else {
                            navController.navigate(Screen.PlayerInformation.route)
                        }
                    } else {
                        if (minsh1.value == "" || secsh1.value == "" || minsh2.value == "" || secsh2.value == ""){
                            showWarning4.value = true
                        } else {
                            navController.navigate(Screen.PlayerInformation.route)
                        }
                    }
                } else {
                    navController.navigate(Screen.PlayerInformation.route)
                }
            },
            modifier = Modifier.height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0FA6F7)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            ),
            shape = RoundedCornerShape(25.dp)
        ){
            Text(
                text = "Enter Series",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HackerSettingsPreview(){
    HackerSettings(navController = NavController(LocalContext.current))
}

fun displayString(mins: String,secs: String): String{
    var minute: String = mins
    var second: String = secs
    if (mins.toInt() < 10){
        minute = "0" + mins.toInt().toString()
    }
    if (secs.toInt() < 10){
        second = "0" + secs.toInt().toString()
    }
    return "$minute : $second"
}
