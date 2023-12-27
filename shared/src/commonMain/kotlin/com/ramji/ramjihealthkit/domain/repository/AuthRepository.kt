package com.ramji.ramjihealthkit.domain.repository

import com.ramji.ramjihealthkit.domain.data.LoginRequest
import com.ramji.ramjihealthkit.util.network.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun loginUser(loginRequest: LoginRequest): Flow<Result<Any>>
}