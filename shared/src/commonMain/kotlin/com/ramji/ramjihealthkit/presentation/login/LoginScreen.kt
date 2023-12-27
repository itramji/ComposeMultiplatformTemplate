package com.ramji.ramjihealthkit.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramji.ramjihealthkit.presentation.AuthViewModel
import com.ramji.ramjihealthkit.presentation.component.AppAlertDialog
import com.ramji.ramjihealthkit.presentation.component.AppTextFieldWithError
import com.ramji.ramjihealthkit.presentation.component.circleOutlineBtn
import com.ramji.ramjihealthkit.presentation.component.inLineText
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(viewModel: AuthViewModel, onNavigate: (String) -> Unit) {

    val state by viewModel.loginState.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(state.onLoginError, state.onLoginSuccess) {
        print("LaunchedEffect" + state.onLoginError + "state.onLoginError--->" + state.onLoginSuccess)
        if (state.onLoginSuccess.isNullOrBlank().not()) {
            onNavigate("can navigate")
        }
    }

    Surface(modifier = Modifier.fillMaxSize()
        .clickable(indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            keyboardController?.hide()
        }) {

        Box(Modifier.imePadding()) {

            if (state.onLoginError != null) {
                AppAlertDialog(dialogText = state.onLoginSuccess ?: state.onLoginError,
                    onConfirmation = {
                        viewModel.updateState()
                    })
            }

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
                    .wrapContentHeight(Alignment.Bottom).verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colorScheme.background).padding(bottom = 16.dp)
            ) {

                Image(
                    painter = painterResource("doc_illustration.jpg"),
                    contentDescription = "contact?.firstName",
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                )

                inLineText("  Log in or Sign up  ")

                Spacer(Modifier.size(24.dp))

                AppTextFieldWithError(
                    value = viewModel.request.mobile ?: "",
                    onValue = { viewModel.onEvent(LoginEvent.onMobileNumberChanged(it)) },
                    error = state.mobileNumberError,
                    label = "Mobile Number",
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next, keyboardType = KeyboardType.Phone
                    )
                )

                Spacer(Modifier.size(8.dp))

                AppTextFieldWithError(
                    value = viewModel.request.password ?: "",
                    onValue = { viewModel.onEvent(LoginEvent.onPasswordChanged(it)) },
                    error = state.passwordError,
                    label = "Password",
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
                    )
                )

                Spacer(Modifier.size(16.dp))

                Button(
                    onClick = {
                        viewModel.onEvent(LoginEvent.onSubmitClicked)
                    },
                    enabled = state.canBtnEnable(),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("SignIn")
                }

                Spacer(Modifier.size(12.dp))

                inLineText("  or ")

                Spacer(Modifier.size(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    circleOutlineBtn("ic_google.png") {

                    }

                    circleOutlineBtn("ic_more.png") {

                    }
                }

                Spacer(Modifier.size(32.dp))

                Text(
                    "By continuing, You agree to our \n Terms of Service, Privacy Policy & Content Policy",
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.fillMaxWidth(),
                )
            }

            if (state.isLoading) CircularProgressIndicator(
                Modifier.fillMaxSize().wrapContentSize().align(Alignment.Center)
            )
        }

    }
}
