package com.messenger.controller;

import com.messenger.dto.MessageDto
import com.messenger.services.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ["/api/v1"])
class MessageController(
    @Autowired val messageService: MessageService
) {

    @PostMapping(value = ["/message"], consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sendMessage(message: MessageDto) {
        messageService.sendMessage(message)
    }
}
