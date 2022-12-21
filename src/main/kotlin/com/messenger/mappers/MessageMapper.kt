package com.messenger.mappers

import com.messenger.dto.MessageDto
import com.messenger.jpa.entities.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageMapper(
    @Autowired val userMapper: UserMapper,
    @Autowired val chatMapper: ChatMapper
) {
    fun toDto(messageEntity: Message) : MessageDto {
        return MessageDto(
            messageEntity.id,
            messageEntity.sender?.let { userMapper.toDto(it) },
            messageEntity.body,
            messageEntity.chat?.let { chatMapper.toDto(it) },
            messageEntity.createdAt
        )
    }

    fun toEntity(messageDto: MessageDto) : Message {
        return Message(
            messageDto.id,
            messageDto.sender?.let { userMapper.toEntity(it) },
            messageDto.body,
            messageDto.chat?.let { chatMapper.toEntity(it) },
            messageDto.createdAt
        )
    }
}