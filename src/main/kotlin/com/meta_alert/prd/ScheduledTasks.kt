package com.meta_alert.scheduler

import com.meta_alert.service.ScheduledEventService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTaskScheduler(val service: ScheduledEventService) {

    @Scheduled(fixedRate = 3600000)
    fun executePendingEvents() {
        val events = service.getPendingEvents()

        events.forEach { event ->
            event.status = "COMPLETED"
            service.createEvent(event)
        }
    }
}
