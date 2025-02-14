package com.meta_alert.prd.adapter.controllers

import com.meta_alert.model.ScheduledEvent
import com.meta_alert.service.ScheduledEventService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scheduled-events")
class ScheduledEventController(
    private val scheduleEventService: ScheduledEventService
) {

    @PostMapping
    fun createEvent(@RequestBody event: ScheduledEvent): ResponseEntity<ScheduledEvent> {
        val savedEvent = scheduleEventService.createEvent(event)

        return ResponseEntity.ok(savedEvent)
    }
}