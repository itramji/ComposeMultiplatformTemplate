package com.ramji.ramjihealthkit.presentation.login

data class LoginState(

    var mobileNumberError: String? = null,
    var passwordError: String? = null,

    var onLoginError: String? = null,
    var onLoginSuccess: String? = null,

    var isLoading: Boolean = false,
) {

    fun canBtnEnable() = mobileNumberError.isNullOrBlank() && passwordError.isNullOrBlank()

}