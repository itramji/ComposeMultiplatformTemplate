package com.ramji.ramjihealthkit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.ramji.ramjihealthkit.data.repository.AuthRepositoryImpl
import com.ramji.ramjihealthkit.data.repository.SettingsRepositoryImpl
import com.ramji.ramjihealthkit.presentation.AuthViewModel
import com.ramji.ramjihealthkit.presentation.home.HomeScreen
import com.ramji.ramjihealthkit.presentation.login.LoginScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun Navigation(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = if (SettingsRepositoryImpl.token.isNullOrBlank()) NavigationScreen.Login.route else NavigationScreen.Home.route,
    ) {
        scene(route = NavigationScreen.Login.route) {
            val viewModel = AuthViewModel(AuthRepositoryImpl())
            LoginScreen(viewModel) {
                navigator.navigate(NavigationScreen.Home.route)
            }
        }
        scene(route = NavigationScreen.Home.route) {
            HomeScreen() {
                navigator.goBack()
            }
        }
    }
}

@Composable
fun currentRoute(navigator: Navigator): String? {
    return navigator.currentEntry.collectAsState(null).value?.route?.route

}