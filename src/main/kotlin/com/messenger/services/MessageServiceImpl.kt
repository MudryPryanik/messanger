package com.messenger.services

import com.messenger.dto.MessageDto
import com.messenger.jpa.repository.MessageRepository
import com.messenger.mappers.MessageMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(
    @Autowired val messageRepository: MessageRepository,
    @Autowired val messageMapper: MessageMapper
) : MessageService {

    override fun sendMessage(message: MessageDto) {
        val messageEntity: MessageDto = messageRepository.save(messageMapper.toEntity(message))
            .let{ messageMapper.toDto(it) }

        TODO("Отправка уведомления")
    }
}