package com.ramji.ramjihealthkit.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun inLineText(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            color = MaterialTheme.colorScheme.surfaceVariant,
            thickness = 1.dp,
            modifier = Modifier.weight(1f).padding(end = 8.dp)
        )
        Text(
            text
        )
        Divider(
            color = MaterialTheme.colorScheme.surfaceVariant,
            thickness = 1.dp,
            modifier = Modifier.weight(1f).padding(start = 8.dp)
        )
    }
}