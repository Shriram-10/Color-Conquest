package com.example.task1colourconquest

import androidx.compose.ui.graphics.Color

data class Star(
    val id: Int,
    val x: Float,
    val y: Float,
    val size: Float,
    val color: Color,
    val rotationSpeed: Float
)

