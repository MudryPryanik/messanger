package com.messenger.mappers

import com.messenger.dto.MessageDto
import com.messenger.jpa.entities.Message
import org.springframework.stereotype.Component

@Component
class MessageMapper {
    fun toDto(messageEntity: Message) : MessageDto {
        return MessageDto()
    }

    fun toEntity(messageDto: MessageDto) : Message {
        return Message()
    }
}