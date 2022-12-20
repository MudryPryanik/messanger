package com.messenger.mappers

import com.messenger.dto.UserDto
import com.messenger.jpa.entities.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toDto(userEntity: User) : UserDto {
        return UserDto()
    }

    fun toEntity(userDto: UserDto) : User {
        return User()
    }
}