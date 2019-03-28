package com.example.loginer.model

interface UserRepository {
    fun findByLoginAndPassword(login: String, password: String): User?
}