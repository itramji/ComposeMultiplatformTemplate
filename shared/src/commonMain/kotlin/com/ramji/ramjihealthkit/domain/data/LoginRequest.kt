package com.ramji.ramjihealthkit.domain.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val mobile: String? = null, val password: String? = null)