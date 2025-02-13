package com.meta_alert.service

import com.meta_alert.model.ScheduledEvent
import com.meta_alert.repository.ScheduledEventRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ScheduledEventService(
    val repository: ScheduledEventRepository) {

    fun createEvent(event: ScheduledEvent): ScheduledEvent {
        return repository.save(event)
    }

    fun getPendingEvents(): List<ScheduledEvent> {
        val now = LocalDateTime.now()
        return repository.findByStatusAndEventTimeBefore("PENDING", now)
    }

    fun getEventById(id: Long): ScheduledEvent? {
        return repository.findById(id)
    }

    fun deleteEvent(id: Long) {
        repository.deleteById(id)
    }
}
