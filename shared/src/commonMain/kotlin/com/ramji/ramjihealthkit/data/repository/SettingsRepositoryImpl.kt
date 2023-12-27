package com.ramji.ramjihealthkit.data.repository

import com.ramji.ramjihealthkit.domain.data.SessionKeys
import com.ramji.ramjihealthkit.domain.repository.SettingsRepository
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

object SettingsRepositoryImpl : SettingsRepository {
    private val settings: Settings by lazy { Settings() }

    override var token: String?
        get() = settings[SessionKeys.TOKEN.key]
        set(value) {
            settings[SessionKeys.TOKEN.key] = value
        }


    // clean all the stored values
    override fun cleanStorage() {
        settings.clear()
    }
}