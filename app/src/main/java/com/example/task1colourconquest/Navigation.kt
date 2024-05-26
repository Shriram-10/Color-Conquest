package com.example.task1colourconquest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
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
        composable(
            route = Screen.HomePage.route,
            enterTransition = {slideInHorizontally { it }},
            popEnterTransition = {slideInHorizontally { it }}
        ) {
            HomePage(navController = navController)
        }
        composable(
            route = Screen.ModesPage.route,
            enterTransition = {slideInHorizontally { it }},
//            exitTransition = {slideOutHorizontally { it }},
            popEnterTransition = {slideInHorizontally { it }},
//            popExitTransition = {slideOutHorizontally { it }}
        ) {
                ModesPage(navController = navController)
        }
        composable(
            route = Screen.HackerSettings.route,
            enterTransition = { slideInHorizontally { it }},
            popEnterTransition = { slideInHorizontally { it }}
        ){
            HackerSettings(navController = navController)
        }
        composable(
            route = Screen.PlayerInformation.route,
            enterTransition = {slideInHorizontally { it }},
//            exitTransition = {slideOutHorizontally { it }},
            popEnterTransition = {slideInHorizontally { it }},
//            popExitTransition = {slideOutHorizontally { it }}
        ) {
                PlayerPage(navController = navController)
        }
        composable(
            route = Screen.GamePage.route,
            enterTransition = {slideInHorizontally { it }},
//            exitTransition = {slideOutHorizontally { it }},
            popEnterTransition = {slideInHorizontally { it }},
//            popExitTransition = {slideOutHorizontally { it }}
        ) {
                GamePage(navController = navController, viewModel1 = viewModel(), viewModel2 = viewModel())
        }
        composable(
            route = Screen.GameResult.route,
        ) {
            DisplayWinner(navController = navController)
        }
    }
}







