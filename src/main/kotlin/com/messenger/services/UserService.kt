package com.messenger.services

import com.messenger.dto.UserDto
import java.util.UUID

interface UserService {
    fun registerUser(user: UserDto): UserDto

    fun findUser(id: UUID): UserDto?

    fun findUser(username: String): UserDto?

    fun findUsers(usernamePattern: String): Collection<UserDto>
}