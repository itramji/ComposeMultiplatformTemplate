package com.ramji.ramjihealthkit.di

import com.ramji.ramjihealthkit.Platform
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val platformModule = module {
    singleOf(::Platform)
}