package com.ramji.ramjihealthkit.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AppTextFieldWithError(
    value: String,
    onValue: (String) -> Unit,
    label: String,
    error: String? = null,
    keyboardOptions: KeyboardOptions,
) {
    Column {

        OutlinedTextField(
            value = value,
            onValueChange = onValue,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions
        )
        println("AppTextFieldWithError: $label $error")
        if (error.isNullOrBlank().not()) {
            Text(
                error!!,
                modifier = Modifier.align(Alignment.End),
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}

