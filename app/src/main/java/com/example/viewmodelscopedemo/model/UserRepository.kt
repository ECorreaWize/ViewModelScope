package com.example.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1,"Edgar"),
            User(2,"Gustavo"),
            User(3,"Edmundo"),
            User(4, "Graciela")
        )

        return users
    }
}