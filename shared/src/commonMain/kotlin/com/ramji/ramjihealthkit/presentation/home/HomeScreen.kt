package com.ramji.ramjihealthkit.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ramji.ramjihealthkit.data.repository.SettingsRepositoryImpl

@Composable
fun HomeScreen(onLogout: () -> Unit) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("Hi you have reached home")

        Button(onClick = {
            SettingsRepositoryImpl.cleanStorage()
            onLogout()
        }, modifier = Modifier.wrapContentSize()) {
            Text("Logout")
        }
    }

}