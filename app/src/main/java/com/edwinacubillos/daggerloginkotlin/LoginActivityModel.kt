package com.edwinacubillos.daggerloginkotlin

class LoginActivityModel(var repository: LoginRepository) : LoginActivityMVP.Model {

    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser(User(firstName, lastName))
    }

    override fun getUser(): User = repository.getUser()
}