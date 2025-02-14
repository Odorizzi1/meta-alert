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

    fun getEvent(status:String):List<ScheduledEvent>{
        return repository.getEvents(status)
    }

}
