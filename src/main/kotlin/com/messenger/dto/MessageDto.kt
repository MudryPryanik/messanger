package com.messenger.dto

import java.time.LocalDateTime
import java.util.*

class MessageDto(
    var id: UUID? = null,
    var sender: UserDto? = null,
    var body: String? = null,
    var chat: ChatDto? = null,
    var createdAt: LocalDateTime? = null
)