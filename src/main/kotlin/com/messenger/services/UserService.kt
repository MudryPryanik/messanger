package com.messenger.services

import com.messenger.dto.ChatDto
import com.messenger.dto.UserDto
import java.util.*

interface UserService {
    fun registerUser(user: UserDto): UserDto?

    fun userChats(userId: UUID): Collection<ChatDto>

    fun findUser(username: String): UserDto?

    fun findUsers(usernamePattern: String): Collection<UserDto>
}