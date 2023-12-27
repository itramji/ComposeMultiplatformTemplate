package com.ramji.ramjihealthkit.presentation.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppAlertDialog(
    onDismissRequest: (() -> Unit)? = null,
    onConfirmation: (() -> Unit)? = null,
    dialogTitle: String = "Alert",
    dialogText: String?,
    icon: ImageVector? = null,
) {
    AlertDialog(
        icon = {
            icon?.let {
                Icon(icon, contentDescription = "Example Icon")
            }
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText ?: "")
        },
        onDismissRequest = {
            onDismissRequest?.invoke()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation?.invoke()
                }
            ) {
                Text(if (onDismissRequest == null) "Dismiss" else "Confirm")
            }
        },
        dismissButton = onDismissRequest?.let {
            {
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text("Dismiss")
                }
            }
        }

    )
}