package com.ramji.ramjihealthkit.presentation.login

sealed interface LoginEvent {

    data class onMobileNumberChanged(val value: String) : LoginEvent
    data class onPasswordChanged(val value: String) : LoginEvent
    data object onSubmitClicked : LoginEvent
}