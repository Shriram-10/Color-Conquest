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
    false,false,false,false,false,
    false,false,false,false,false,
    false,false,false,false,false,
    false,false,false,false,false,
    false,false,false,false,false
)

var ColoringBG = mutableStateListOf<Color>(
    Color(0xFF0FA6F7), Color(0xFFED6A5E)
)

var Coloring = mutableStateListOf<Color>(
    Color(0xFFC7F1FD), Color(0xFFF2D1CD)
)

var colorTile = mutableStateListOf<Color>(
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1)
)

var colorCircle = mutableStateListOf<Color>(
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1),
    Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1), Color(0xFFF2E6D1)
)

var playerCover : SnapshotStateList<SnapshotStateList<Boolean>> = mutableStateListOf(
    mutableStateListOf(
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false
    ),
    mutableStateListOf(
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false
    )
)

var playerPoints : SnapshotStateList<SnapshotStateList<Int>> = mutableStateListOf(
    mutableStateListOf(
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0
    ),
    mutableStateListOf(
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0,
        0, 0, 0, 0, 0
    )
)

var counter = mutableStateOf(0)
var backgroundColor = mutableStateOf(Color(0xFF0FA6F7))
var pointsTotal = mutableStateListOf(0,0)
val thisPlayer = mutableStateOf(1)
val otherPlayer = mutableStateOf(0)
val r = mutableStateOf(5)
val c = mutableStateOf(5)

var player1Name = mutableStateOf("")
var player2Name = mutableStateOf("")

var winnerName = mutableStateOf("")
var sizeOfOtherCircle = playerCover[if (counter.value % 2 == 0) 1 else 0]
var sizeOfCircle = playerCover[if (counter.value % 2 == 0) 0 else 1]

var mode = mutableStateOf(1)

var mins = mutableStateOf("")
var secs = mutableStateOf("")

var chooseHandicap = mutableStateOf(false)
var showDropDown = mutableStateOf(false)
var showTimerDialog = mutableStateOf(false)
var timedOrNot = mutableStateOf(false)
var displayChooseTime = mutableStateOf(false)

var showWarning1 = mutableStateOf(false)
var showWarning2 = mutableStateOf(false)
var showWarning3 = mutableStateOf(false)

var mins1 = mutableStateOf(0)
var secs1 = mutableStateOf(0)
var mins2 = mutableStateOf(0)
var secs2 = mutableStateOf(0)

var minsh1 = mutableStateOf("")
var secsh1 = mutableStateOf("")
var minsh2 = mutableStateOf("")
var secsh2 = mutableStateOf("")

var causeDelay = mutableStateOf(false)
