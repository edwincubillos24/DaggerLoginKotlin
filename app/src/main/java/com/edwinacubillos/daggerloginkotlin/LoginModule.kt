package com.edwinacubillos.daggerloginkotlin

import dagger.Module
import dagger.Provides

@Module
class LoginModule{

    @Provides
    fun provideLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter{
        return LoginActivityPresenter(model)
    }

    @Provides
    fun provideLoginActivityModel(repository: LoginRepository) : LoginActivityMVP.Model{
        return LoginActivityModel(repository)
    }

    @Provides
    fun provideLoginActivityRepository(): LoginRepository{
        return MemoryRepository();
    }
}