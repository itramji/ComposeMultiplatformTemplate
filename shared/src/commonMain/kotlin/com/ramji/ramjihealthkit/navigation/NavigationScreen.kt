package com.ramji.ramjihealthkit.navigation

import com.ramji.ramjihealthkit.util.AppString

sealed class NavigationScreen(
    val route: String,
    val title: String = AppString.APP_TITLE
) {

    object Login : NavigationScreen("login_screen")
    object Home : NavigationScreen("home_screen")

}