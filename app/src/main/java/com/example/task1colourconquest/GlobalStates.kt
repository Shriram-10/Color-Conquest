package com.example.task1colourconquest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color

var winner = mutableStateOf(-1)

var clicked = mutableStateListOf<Boolean>(
//    false,false,false,false,false,
//    false,false,false,false,false,
//    false,false,false,false,false,
//    false,false,false,false,false,
//    false,false,false,false,false
)

var ColoringBG = mutableStateListOf<Color>(
    Color(0xFF0FA6F7), Color(0xFFED6A5E)
)

var Coloring = mutableStateListOf<Color>(
    Color(0xFFC7F1FD), Color(0xFFF2D1CD)
)

var colorTile = mutableStateListOf<Color>(
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1)
)

var colorCircle = mutableStateListOf<Color>(
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
//    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1)
)

var playerCover : SnapshotStateList<SnapshotStateList<Boolean>> = mutableStateListOf(
    mutableStateListOf(
//        false, false, false, false, false,
//        false, false, false, false, false,
//        false, false, false, false, false,
//        false, false, false, false, false,
//        false, false, false, false, false
    ),
    mutableStateListOf(
//        false, false, false, false, false,
//        false, false, false, false, false,
//        false, false, false, false, false,
//        false, false, false, false, false,
//        false, false, false, false, false
    )
)

var playerPoints : SnapshotStateList<SnapshotStateList<Int>> = mutableStateListOf(
    mutableStateListOf(
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0
    ),
    mutableStateListOf(
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0,
//        0, 0, 0, 0, 0
    )
)

var counter = mutableStateOf(0)
var backgroundColor = mutableStateOf(Color(0xFF0FA6F7))
var pointsTotal = mutableStateListOf(0,0)
val thisPlayer = mutableStateOf(1)
val otherPlayer = mutableStateOf(0)
var r = mutableStateOf(0)
var c = mutableStateOf(0)
var rInput = mutableStateOf("")
var cInput = mutableStateOf("")

var player1Name = mutableStateOf("")
var player2Name = mutableStateOf("")

var winnerName = mutableStateOf("")
var sizeOfOtherCircle = playerCover[if (counter.value % 2 == 0) 1 else 0]
var sizeOfCircle = playerCover[if (counter.value % 2 == 0) 0 else 1]

var mode = mutableStateOf(0)

var chooseHandicap = mutableStateOf(false)
var showDropDown = mutableStateOf(false)
var showTimerDialog = mutableStateOf(false)
var timedOrNot = mutableStateOf(false)
var displayChooseTime = mutableStateOf(false)

var showWarning1 = mutableStateOf(false)
var showWarning2 = mutableStateOf(false)
var showWarning3 = mutableStateOf(false)
var showWarning4 = mutableStateOf(false)
var showWarning5 = mutableStateOf(false)
var showWarning6 = mutableStateOf(false)
var showWarning7 = mutableStateOf(false)
var showWarning8 = mutableStateOf(false)
var showWarning9 = mutableStateOf(false)

var mins = mutableStateOf("")
var secs = mutableStateOf("")
var minsh1 = mutableStateOf("")
var secsh1 = mutableStateOf("")
var minsh2 = mutableStateOf("")
var secsh2 = mutableStateOf("")

var isRunning1 = mutableStateOf(false)
var isRunning2 = mutableStateOf(false)
var resetTimer = mutableStateListOf(false,false)

var setCustomGrid = mutableStateOf(false)
var changeGridSize = mutableStateOf(false)
var showGridChangeDialog = mutableStateOf(false)

var chooseSeriesHandicap = mutableStateOf(false)
var optionsSeriesDialog = mutableStateOf(false)
var customSeries = mutableStateOf(true)
var noOfMatchesInput = mutableStateOf("")
var noOfMatches = mutableStateOf(1)
fun generateGridSizeList(r: Int, c: Int){
    for (i in 0..r * c - 1 ) {
        clicked.add(false)
        colorTile.add(Color(0xFFF2E6D1))
        colorCircle.add(Color(0xFFF2E6D1))
        playerCover[0].add(false)
        playerCover[1].add(false)
        playerPoints[0].add(0)
        playerPoints[1].add(0)
    }
}

fun removeListItems(r: Int, c:Int){
    for (i in 0..r * c - 1){
        clicked.removeAt(r * c - i - 1)
        colorTile.removeAt(r * c - i - 1)
        colorCircle.removeAt(r * c - i - 1)
        playerCover[0].removeAt(r * c - i - 1)
        playerCover[1].removeAt(r * c - i - 1)
        playerPoints[0].removeAt(r * c - i - 1)
        playerPoints[1].removeAt(r * c - i - 1)
    }
}