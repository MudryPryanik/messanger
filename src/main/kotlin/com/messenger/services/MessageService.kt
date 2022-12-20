package com.messenger.services

import com.messenger.dto.MessageDto

interface MessageService {

    fun sendMessage(message: MessageDto)
}