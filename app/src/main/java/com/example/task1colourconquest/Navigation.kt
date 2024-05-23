package com.example.task1colourconquest

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Screen.HomePage.route) {
        composable(route = Screen.HomePage.route) {
            HomePage(navController = navController)
        }
        composable(route = Screen.PlayerInformation.route) {
            PlayerPage(navController = navController)
        }
        composable(route = Screen.GamePage.route) {
            GamePage(navController = navController)
        }
        composable(route = Screen.GameResult.route) {
            DisplayWinner(navController = navController)
        }
    }
}







