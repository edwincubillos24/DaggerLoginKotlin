package com.edwinacubillos.daggerloginkotlin

interface LoginRepository {

    fun saveUser(user: User)

    fun getUser(): User
}