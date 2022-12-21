package com.messenger.dto

import java.time.LocalDateTime
import java.util.*

data class UserDto(
    var id: UUID?,
    var username: String?,
    var phoneNumber: String?,
    var password: String?,
    var accountStatus: AccountStatus?,
    var chats: Collection<ChatDto>,
    var createdAt: LocalDateTime?
)