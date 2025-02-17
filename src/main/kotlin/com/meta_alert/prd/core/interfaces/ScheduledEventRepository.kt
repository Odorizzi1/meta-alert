package com.meta_alert.prd.core.interfaces

import com.meta_alert.prd.model.ScheduledEvent
interface ScheduledEventRepository {
fun save(event : ScheduledEvent):ScheduledEvent
fun getEvents(status: String): List<ScheduledEvent>
}