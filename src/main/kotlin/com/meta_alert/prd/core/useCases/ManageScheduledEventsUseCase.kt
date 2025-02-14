package com.meta_alert.prd.core.useCases
import com.meta_alert.repository.ScheduledEventRepository
import com.meta_alert.service.ScheduledEventService

class ManageScheduledEventsUseCase(
   private val scheduledEventService: ScheduledEventService
) {
    fun executePendingEvents() {
        val pendingEvents = scheduledEventService.getEvent("PENDING")

        pendingEvents.forEach { event ->


        }
    }
}
