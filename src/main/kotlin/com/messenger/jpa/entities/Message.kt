package com.messenger.jpa.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "messages")
class Message(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    var sender: User? = null,
    var body: String? = null,
    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    var chat: Chat? = null,
    var createdAt: LocalDateTime? = null
)