package com.ramji.ramjihealthkit.data.repository

import com.ramji.ramjihealthkit.data.dto.LoginResponse
import com.ramji.ramjihealthkit.domain.data.LoginRequest
import com.ramji.ramjihealthkit.domain.repository.AuthRepository
import com.ramji.ramjihealthkit.util.AppConstant
import com.ramji.ramjihealthkit.util.network.KtorClient
import com.ramji.ramjihealthkit.util.network.Result
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl : AuthRepository {

    override suspend fun loginUser(loginRequest: LoginRequest): Flow<Result<Any>> = flow {
        emit(Result.loading())
        try {
            val data = KtorClient.client
                .post("${AppConstant.BASE_URL}/user-service/api/v1/signIn") {
                    setBody(loginRequest)
                    contentType(ContentType.Application.Json)
                }
                .body<LoginResponse>()

            SettingsRepositoryImpl.token = data.token

            emit(Result.Success(data))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

}
