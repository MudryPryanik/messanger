package com.messenger.jpa.repository

import com.messenger.jpa.entities.Message
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MessageRepository : CrudRepository<Message, UUID>