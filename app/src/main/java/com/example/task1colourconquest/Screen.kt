package com.example.task1colourconquest

sealed class Screen(val route: String) {
    object HomePage : Screen("home_page")
    object ModesPage : Screen("modes_page")
    object PlayerInformation : Screen("player_info")
    object GamePage : Screen("game_page")
    object GameResult : Screen("game_result")
    object HackerSettings : Screen("hacker_settings")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
