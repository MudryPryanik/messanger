package com.messenger.jpa.listeners

import com.messenger.jpa.entities.User
import jakarta.persistence.PrePersist
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UserListener {
    @PrePersist
    fun hashPassword(user: User) {
        user.password = BCryptPasswordEncoder().encode(user.password)
    }
}