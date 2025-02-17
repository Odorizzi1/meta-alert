package com.meta_alert.prd.core.useCases
import com.meta_alert.prd.adapter.gateways.MetabaseGateway
import com.meta_alert.prd.adapter.gateways.SlackGateway

import com.meta_alert.prd.services.ScheduledEventService
import org.springframework.stereotype.Service

@Service
class ManageScheduledEventsUseCase(
   private val scheduledEventService: ScheduledEventService,
   private val metabaseGateway: MetabaseGateway,
   private val slackGateway: SlackGateway
) {
    fun executePendingEvents() {
        val pendingEvents = scheduledEventService.getEvent("PENDING")

        pendingEvents.forEach { event ->
         val getInfoToMetabase = metabaseGateway.fetchData("2424")
            val count = getInfoToMetabase.count().toString()
            println(count)
            slackGateway.sendMessage("/teste", count)
        }
    }
}
