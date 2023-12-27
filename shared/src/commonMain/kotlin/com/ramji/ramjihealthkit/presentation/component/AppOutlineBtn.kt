package com.ramji.ramjihealthkit.presentation.component


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
@OptIn(ExperimentalResourceApi::class)
fun circleOutlineBtn(res: String, onClick: () -> Unit) {
    OutlinedIconButton(
        border =
        BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.size(64.dp).padding(8.dp),
        onClick = onClick
    ) {
        Image(
            painter = painterResource(res),
            contentDescription = "contact?.firstName",
            modifier = Modifier.padding(12.dp)
        )
    }
}