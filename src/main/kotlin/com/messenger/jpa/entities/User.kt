package com.messenger.jpa.entities

import com.messenger.dto.AccountStatus
import com.messenger.jpa.listeners.UserListener
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "accounts")
@EntityListeners(UserListener::class)
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var userName: String? = null,
    var phoneNumber: String? = null,
    var password: String? = null,
    var status: String? = null,

    @Enumerated(value = EnumType.STRING)
    var accountStatus: AccountStatus? = null,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "chats_users",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "chat_id")]
    )
    var chats: Collection<Chat> = emptyList(),
    var createdAt: LocalDateTime? = null
)