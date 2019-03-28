package com.example.loginer.model

class UserRepositoryImpl: UserRepository {

    companion object {
        private const val VALID_LOGIN = "test"
        private const val VALID_PASSWORD = "test"
    }

    override fun findByLoginAndPassword(login: String, password: String): User?{
        return if(VALID_LOGIN == login && VALID_PASSWORD == password)
            User(login, password)
        else
            null
    }
}