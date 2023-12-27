package com.ramji.ramjihealthkit.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.ramji.ramjihealthkit.domain.data.LoginRequest
import com.ramji.ramjihealthkit.domain.repository.AuthRepository
import com.ramji.ramjihealthkit.presentation.login.LoginEvent
import com.ramji.ramjihealthkit.presentation.login.LoginState
import com.ramji.ramjihealthkit.util.network.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    var request: LoginRequest by mutableStateOf(LoginRequest())


    private fun login() {
        viewModelScope.launch {

            repository.loginUser(request).distinctUntilChanged().collect { result ->
                println("login response: $result")
                when (result) {
                    is Result.Success -> {
                        _loginState.update { it.copy(onLoginSuccess = result.toString()) }
                    }

                    is Result.Failure -> {
                        _loginState.update { it.copy(onLoginError = result.exception.message) }
                    }

                    else -> {
                        _loginState.update { it.copy(isLoading = true) }
                    }
                }
            }
        }
    }

    fun onEvent(loginEvent: LoginEvent) {
        println(loginEvent.toString())
        when (loginEvent) {
            is LoginEvent.onMobileNumberChanged -> {
                if (loginEvent.value.length <= 10) {
                    request = request.copy(
                        mobile = loginEvent.value
                    )
                    validateContact()
                }
            }

            is LoginEvent.onPasswordChanged -> {
                request = request.copy(
                    password = loginEvent.value
                )
                validateContact()
            }

            is LoginEvent.onSubmitClicked -> {
                if (validateContact()) {
                    login()
                }
            }
        }
    }

    private fun validateContact(): Boolean {

        println("validateContact")

        _loginState.update {
            it.copy(
                mobileNumberError = if (request.mobile.isNullOrBlank()) "The Mobile Number can't be empty." else null,
                passwordError = if (request.password.isNullOrBlank()) "The Password can't be empty." else null,
            )
        }

        return _loginState.value.canBtnEnable()
    }

    fun updateState() {
        _loginState.update {
            it.copy(onLoginError = null, onLoginSuccess = null, isLoading = false)
        }
    }

}
