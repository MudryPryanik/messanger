package com.messenger.api.controller;

import com.messenger.dto.ChatDto
import com.messenger.dto.UserDto
import com.messenger.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID

@RestController
@RequestMapping(value = ["/api/v1"])
class ChatController(
    @Autowired val chatService: ChatService
) {

    @PostMapping(value = ["/chats"], consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createChat(chatDto: ChatDto): ChatDto {
        return chatService.createChat(chatDto)
    }

    @GetMapping(value = ["/chats/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findChat(@PathVariable id: UUID): ChatDto {
        return chatService.findChat(id)
    }

    @PatchMapping(value = ["/chats/{id}/users"], consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addUsers(@PathVariable id: UUID, users: Collection<UserDto>): ChatDto {
        return chatService.addUsers(id, users)
    }
}
