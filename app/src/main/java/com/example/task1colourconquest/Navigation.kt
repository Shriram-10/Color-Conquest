package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
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
        composable(route = Screen.ModesPage.route) {
            AnimatedVisibility(
                visible = pageNo.value == 2,
                enter = slideInHorizontally {
                    it / 2
                },
            ) {
                ModesPage(navController = navController)
            }
        }
        composable(route = Screen.PlayerInformation.route) {
            AnimatedVisibility(
                visible = pageNo.value == 3,
                enter = slideInHorizontally {
                    it / 2
                },
            ){
                PlayerPage(navController = navController)
            }
        }
        composable(route = Screen.GamePage.route) {
            AnimatedVisibility(
                visible = pageNo.value == 4,
                enter = slideInHorizontally {
                    it / 2
                },
            ){
                GamePage(navController = navController)
            }
        }
        composable(route = Screen.GameResult.route) {
            DisplayWinner(navController = navController)
        }
    }
}







