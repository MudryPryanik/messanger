package com.messenger.services

import com.messenger.dto.ChatDto
import com.messenger.dto.UserDto
import com.messenger.jpa.entities.Chat
import com.messenger.jpa.repository.ChatRepository
import com.messenger.mappers.ChatMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatServiceImpl(
    @Autowired val chatRepository: ChatRepository,
    @Autowired val chatMapper: ChatMapper
) : ChatService {

    override fun findChat(id: UUID): ChatDto {
        return chatRepository.findById(id).orElseThrow().let { chatMapper.toDto(it) }
    }

    override fun createChat(chat: ChatDto): ChatDto {
        return chatRepository.save(chatMapper.toEntity(chat)).let { chatMapper.toDto(it) }
    }

    override fun addUsers(id: UUID, users: Collection<UserDto>): ChatDto {
        val chat: Chat = chatRepository.findById(id)
            .orElseThrow()

        chat.users.plus(users)

        return chatRepository.save(chat).let { chatMapper.toDto(it) }
    }
}