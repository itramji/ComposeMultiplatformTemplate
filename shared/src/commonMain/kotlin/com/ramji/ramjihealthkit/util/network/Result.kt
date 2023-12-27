package com.ramji.ramjihealthkit.util.network

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure(val exception: Exception) : Result<Nothing>()
    data class Loading(val msg: String = "") : Result<Nothing>()
    companion object {
        fun <T> success(data: T): Result<T> = Success(data)
        fun failure(exception: Exception = Exception("Something went wrong")): Result<Nothing> =
            Failure(exception)

        fun loading() = Loading()
    }

    fun isLoading() = this is Loading
}
