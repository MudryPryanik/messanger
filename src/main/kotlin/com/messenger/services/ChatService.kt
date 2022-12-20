package com.messenger.services

import com.messenger.dto.ChatDto
import com.messenger.dto.UserDto
import java.util.*

interface ChatService {

    fun findChat(id: UUID): ChatDto

    fun createChat(chat: ChatDto): ChatDto

    fun addUsers(id: UUID, users: Collection<UserDto>): ChatDto
}