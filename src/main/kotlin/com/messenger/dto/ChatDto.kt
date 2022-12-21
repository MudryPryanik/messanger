package com.messenger.dto

import java.time.LocalDateTime
import java.util.*

class ChatDto(
    var id: UUID? = null,
    var messages: Collection<MessageDto> = emptyList(),
    var users: Collection<UserDto> = emptyList(),
    val createdAt: LocalDateTime? = null
)