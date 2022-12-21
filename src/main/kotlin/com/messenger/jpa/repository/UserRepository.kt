package com.messenger.jpa.repository

import com.messenger.jpa.entities.Chat
import com.messenger.jpa.entities.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {
    fun findByUsername(userName: String): User?

    fun findAllByUsernameLike(userNamePattern: String): Collection<User>
}