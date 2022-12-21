package com.messenger.mappers

import com.messenger.dto.UserDto
import com.messenger.jpa.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
class UserMapper(@Autowired @Lazy val chatMapper: ChatMapper) {
    fun toDto(userEntity: User) : UserDto {
        return UserDto(
            userEntity.id,
            userEntity.username,
            userEntity.phoneNumber,
            userEntity.password,
            userEntity.accountStatus,
            userEntity.chats.stream()
                .map { chatMapper.toDto(it) }
                .toList(),
            userEntity.createdAt
        )
    }

    fun toEntity(userDto: UserDto) : User {
        return User(
            userDto.id,
            userDto.username,
            userDto.phoneNumber,
            userDto.password,
            userDto.accountStatus,
            userDto.chats.stream()
                .map { chatMapper.toEntity(it) }
                .toList(),
            userDto.createdAt
        )
    }
}