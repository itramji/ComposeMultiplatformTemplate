package com.ramji.ramjihealthkit.domain.repository

interface SettingsRepository {
    // #1 - Primitive type
    var token: String?

//    // #2 - Custom type
//    var loginInfo: LoginInfo?
//
//    // #3 - Observer token value changes
//    val observableToken: Flow<String>

    fun cleanStorage()
}