package com.messenger.services

import com.messenger.dto.ChatDto
import com.messenger.dto.UserDto
import com.messenger.jpa.repository.UserRepository
import com.messenger.mappers.ChatMapper
import com.messenger.mappers.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UserServiceImpl(
    @Autowired val userRepository: UserRepository,
    @Autowired val userMapper: UserMapper,
    @Autowired val chatMapper: ChatMapper
) : UserService {

    override fun registerUser(user: UserDto): UserDto? {
        return userRepository.save(userMapper.toEntity(user)).let { userMapper.toDto(it) }
    }

    override fun userChats(userId: UUID): Collection<ChatDto> {
        return userRepository.findById(userId)
            .orElseThrow()
            .chats
            .stream()
            .map { chatMapper.toDto(it) }
            .collect(Collectors.toList())
    }

    override fun findUser(username: String): UserDto? {
        return userRepository.findByUserName(username)?.let { userMapper.toDto(it) }
    }

    override fun findUsers(usernamePattern: String): Collection<UserDto> {
        return userRepository.findAllByUserNameLike(usernamePattern)
            .stream()
            .map { userMapper.toDto(it) }
            .toList()
    }
}