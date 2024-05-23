package com.example.task1colourconquest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color

var winDialog = mutableStateOf(false)

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
