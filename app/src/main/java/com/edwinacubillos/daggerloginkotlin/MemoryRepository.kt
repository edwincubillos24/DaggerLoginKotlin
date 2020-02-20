package com.edwinacubillos.daggerloginkotlin

class MemoryRepository : LoginRepository {

    private var user: User ?= null

    override fun saveUser(user: User) {
        this.user = user
    }

    override fun getUser(): User {
        if (user == null){
            user = User("Antonio", "Banderas")
            return user!!
        } else {
            return user!!
        }
    }
}
