package com.messenger.jpa.repository

import com.messenger.jpa.entities.Chat
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ChatRepository : CrudRepository<Chat, UUID> {
}