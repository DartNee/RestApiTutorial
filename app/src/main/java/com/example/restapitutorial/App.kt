package com.example.restapitutorial

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context



class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun context(): Context = applicationContext
}
