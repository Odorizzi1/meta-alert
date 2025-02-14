package com.meta_alert.scheduler

import com.meta_alert.prd.core.useCases.ManageScheduledEventsUseCase
import com.meta_alert.service.ScheduledEventService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTaskScheduler(
    val manageScheduledEventsUseCase: ManageScheduledEventsUseCase
) {
    @Scheduled(fixedRate = 3600000)
    fun executePendingEvents() {
        manageScheduledEventsUseCase.executePendingEvents()
    }
}
