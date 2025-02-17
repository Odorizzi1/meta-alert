package com.meta_alert.prd.services

import com.meta_alert.prd.model.ScheduledEvent
import com.meta_alert.prd.repository.ScheduledEventRepository

import org.springframework.stereotype.Service

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
