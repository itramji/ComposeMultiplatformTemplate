package com.ramji.ramjihealthkit

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramji.ramjihealthkit.navigation.Navigation
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean
) {
    PreComposeApp {
        AppTheme(
            darkTheme = darkTheme,
            dynamicColor = dynamicColor
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
            ) {
                Navigation(rememberNavigator())
            }

        }
    }
}