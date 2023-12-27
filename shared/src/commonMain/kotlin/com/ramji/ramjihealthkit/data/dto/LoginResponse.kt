package com.ramji.ramjihealthkit.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(val token: String, val refreshToken: String)