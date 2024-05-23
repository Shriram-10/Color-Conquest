package com.example.task1colourconquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.task1colourconquest.ui.theme.Task1ColourConquestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task1ColourConquestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

val gradientColorList = listOf(
    Color(0xFFF6C57E),
    Color(0xFFED6B71)
)
val gradientColorList2 = listOf(
    Color(0xFF180F10),
    Color(0xFF765244)
)
val gradientColorList3 = listOf(
    Color(0xFF9A695D),
    Color(0xFFD99182)
)



