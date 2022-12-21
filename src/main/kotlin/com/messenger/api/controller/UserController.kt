package com.messenger.api.controller

import com.messenger.dto.UserDto
import com.messenger.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = ["/api/v1"])
class UserController(
    @Autowired val userService: UserService
) {

    @PostMapping(value = ["/users"], consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun register(user: UserDto): UserDto {
        return userService.registerUser(user)
    }

    @GetMapping(value = ["/users/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findUser(@PathVariable id: UUID): UserDto? {
        return userService.findUser(id)
    }

//    @GetMapping(value = ["/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun findUser(@RequestParam username: String): UserDto? {
//        return userService.findUser(username)
//    }

    @GetMapping(value = ["/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fundUsers(@RequestParam usernamePattern: String): Collection<UserDto> {
        return userService.findUsers(usernamePattern)
    }
}