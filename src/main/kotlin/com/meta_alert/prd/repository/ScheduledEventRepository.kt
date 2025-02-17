package com.meta_alert.prd.repository


import com.meta_alert.prd.core.interfaces.ScheduledEventRepository
import com.meta_alert.prd.model.ScheduledEvent
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class ScheduledEventRepository : ScheduledEventRepository {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun save(event: ScheduledEvent): ScheduledEvent {
        return entityManager.merge(event)
    }

    override fun getEvents(status: String): List<ScheduledEvent> {
        val query = entityManager.createQuery(
            "SELECT e FROM ScheduledEvent e WHERE e.status = :status",
            ScheduledEvent::class.java
        )
        query.setParameter("status", status)
        return query.resultList
    }


}
