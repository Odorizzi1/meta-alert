package com.meta_alert.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class ScheduledEvent(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val eventTime: LocalDateTime,
    var status: String
)
