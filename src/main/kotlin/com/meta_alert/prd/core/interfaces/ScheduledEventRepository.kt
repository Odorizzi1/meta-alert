package com.meta_alert.prd.core.interfaces

import com.meta_alert.model.ScheduledEvent

interface ScheduledEventRepository {
fun save(event : ScheduledEvent):ScheduledEvent

}