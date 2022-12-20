package com.messenger.jpa.repository

import com.messenger.jpa.entities.Chat
import com.messenger.jpa.entities.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {
    fun findByUserName(userName: String) : User?

    fun findAllByUserNameLike(userNamePattern: String) : Collection<User>
}