package com.edwinacubillos.root

import android.app.Application
import com.edwinacubillos.daggerloginkotlin.LoginModule

class App : Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .loginModule(LoginModule())
            .build()
    }

    fun getComponent() = component
}