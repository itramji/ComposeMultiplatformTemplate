package com.ramji.ramjihealthkit

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.ramji.ramjihealthkit.theme.DarkColors
import com.ramji.ramjihealthkit.theme.LightColors
import com.ramji.ramjihealthkit.theme.Typography

@Composable
actual fun AppTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}