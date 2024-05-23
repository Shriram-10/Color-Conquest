package com.example.task1colourconquest

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

fun allowClick(i: Int){
    if ((counter.value == 0 || counter.value == 1) || playerCover[thisPlayer.value][i]){
        counter.value++
        increment(i, 0)
    }
}

fun increment(i: Int, caller: Int){

    if (caller == 0){
        playerPoints[thisPlayer.value][i] += 1
    } else {
        if (!playerCover[thisPlayer.value][i] && !playerCover[otherPlayer.value][i]){
            playerPoints[thisPlayer.value][i] += 1
        } else if (playerCover[otherPlayer.value][i]){
            playerPoints[thisPlayer.value][i] = playerPoints[otherPlayer.value][i] + 1
            playerPoints[otherPlayer.value][i] = 0
        } else if (playerCover[thisPlayer.value][i]){
            playerPoints[thisPlayer.value][i] += 1
        }
    }
    coverTracker(i)

    if (playerPoints[thisPlayer.value][i] > 3){
            coverTracker(i)
            playerPoints[thisPlayer.value][i] = 0
            genList(i)
    }

    pointsSum(counter.value)
    if ((pointsTotal[0] == 0 || pointsTotal[1] == 0) && counter.value > 6) {
        resultDeterminer()
    }
    if (caller == 0){
        goNextPlayer()
    }
}

fun coverTracker(i: Int){
    if (playerPoints[thisPlayer.value][i] <= 3){
        playerCover[thisPlayer.value][i] = true
        playerCover[otherPlayer.value][i] = false
        colorChanger(i)
    } else if (playerPoints[thisPlayer.value][i] > 3){
        playerCover[thisPlayer.value][i] = true
        playerCover[otherPlayer.value][i] = false
        colorChanger(i)
        playerCover[thisPlayer.value][i] = false
    }
}

fun colorChanger(i: Int){
    if (playerPoints[thisPlayer.value][i] in 0..3) {
        colorCircle[i] = ColoringBG[thisPlayer.value]
        colorTile[i] = Coloring[thisPlayer.value]
    } else if (playerPoints[thisPlayer.value][i] > 3){
        colorTile[i] = Color(0xFFF2E6D1)
        colorCircle[i] = Color(0xFFF2E6D1)
    }

    for(j in 0..<r.value * c.value) {
        if (playerCover[otherPlayer.value][j]){
            colorTile[j] = Coloring[otherPlayer.value]
        } else {
            colorTile[j] = Color(0xFFF2E6D1)
        }
    }
}

fun goNextPlayer(){
    if (counter.value % 2 == 1){
        thisPlayer.value = 0
        otherPlayer.value = 1
    } else {
        thisPlayer.value = 1
        otherPlayer.value = 0
    }
}

fun genList(i: Int){
    val surround = mutableListOf<Int>(
        i - c.value,
        i - 1,
        i + 1,
        i + c.value
    )

    val surroundFiltered = (surround.filter { it in 0..<r.value * c.value }).toMutableList()

    if(i != 0 && i != r.value * c.value - 1 && i != c.value - 1 && i != (r.value - 1) * c.value) {
        if(i % c.value == 0) {
            surroundFiltered.remove(surroundFiltered[1])
        } else if (i % c.value == c.value - 1) {
            surroundFiltered.remove(surroundFiltered[2])
        }
    } else if(i == c.value - 1) {
        surroundFiltered.remove(surroundFiltered[1])
    } else if(i == (r.value - 1) * c.value) {
        surroundFiltered.remove(surroundFiltered[1])
    } else if(i == r.value * c.value - 1) {
        surroundFiltered.remove(surroundFiltered[2])
    }
    expand(surroundFiltered)
}

fun expand(surround: MutableList<Int>){
    for (index in surround) {
        increment(index, 1)
    }
}

fun pointsSum(counter:Int){
    pointsTotal[0] = 0
    pointsTotal[1] = 0

    for(i in 0..<r.value * c.value){
            pointsTotal[0] += playerPoints[0][i]
            pointsTotal[1] += playerPoints[1][i]
    }
}

fun resultDeterminer(){
    if (pointsTotal[0] == 0) {
        winner.value = 1
        winnerName.value = player1Name.value
    } else if (pointsTotal[1] == 0) {
        winner.value = 0
        winnerName.value = player2Name.value
    } else {
        winner.value = -1
    }
}