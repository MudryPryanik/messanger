package com.messenger.mappers

import com.messenger.dto.ChatDto
import com.messenger.jpa.entities.Chat
import org.springframework.stereotype.Component

@Component
class ChatMapper {
    fun toDto(chatEntity: Chat) : ChatDto {
        return ChatDto()
    }

    fun toEntity(chatDto: ChatDto) : Chat {
        return Chat()
    }
}