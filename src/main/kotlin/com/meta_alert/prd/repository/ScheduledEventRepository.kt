package com.meta_alert.repository

import com.meta_alert.model.ScheduledEvent
import com.meta_alert.prd.core.interfaces.ScheduledEventRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class ScheduledEventRepository : ScheduledEventRepository {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun save(event: ScheduledEvent): ScheduledEvent {
        return entityManager.merge(event)
    }

}
