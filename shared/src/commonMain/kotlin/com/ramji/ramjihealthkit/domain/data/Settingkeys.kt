package com.ramji.ramjihealthkit.domain.data

enum class SessionKeys {
    TOKEN,
    LOGIN_INFO;

    val key get() = this.name
}