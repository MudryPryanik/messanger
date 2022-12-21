package com.messenger.mappers

import com.messenger.dto.ChatDto
import com.messenger.jpa.entities.Chat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
class ChatMapper(
    @Autowired @Lazy val messageMapper: MessageMapper,
    @Autowired @Lazy val userMapper: UserMapper
) {
    fun toDto(chatEntity: Chat) : ChatDto {
        return ChatDto(
            chatEntity.id,
            chatEntity.messages.stream()
                .map { messageMapper.toDto(it) }
                .toList(),
            chatEntity.users.stream()
                .map { userMapper.toDto(it) }
                .toList(),
            chatEntity.createdAt
        )
    }

    fun toEntity(chatDto: ChatDto) : Chat {
        return Chat(
            chatDto.id,
            chatDto.messages.stream()
                .map { messageMapper.toEntity(it) }
                .toList(),
            chatDto.users.stream()
                .map { userMapper.toEntity(it) }
                .toList(),
            chatDto.createdAt
        )
    }
}