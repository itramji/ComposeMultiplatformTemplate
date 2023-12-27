package com.ramji.ramjihealthkit.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.ramji.ramjihealthkit.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = true
            )
        }
    }
}