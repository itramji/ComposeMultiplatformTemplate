package com.ramji.ramjihealthkit

import com.ramji.ramjihealthkit.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class GreetingHelper : KoinComponent {
//    private val greeting : Greeting by inject()
//    fun greet() : String = greeting.greeting()
}

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}