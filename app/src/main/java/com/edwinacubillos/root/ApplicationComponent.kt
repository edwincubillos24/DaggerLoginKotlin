package com.edwinacubillos.root

import com.edwinacubillos.daggerloginkotlin.LoginActivity
import com.edwinacubillos.daggerloginkotlin.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, LoginModule::class))
interface ApplicationComponent {

    fun inject(target: LoginActivity)

}