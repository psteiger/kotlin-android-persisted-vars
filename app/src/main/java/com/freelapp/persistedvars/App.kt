package com.freelapp.persistedvars

import android.app.Application

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var persisted: Persisted
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        persisted = PersistedImpl()
    }
}