package com.meta_alert.prd.core.useCases
import com.meta_alert.prd.adapter.gateways.MetabaseGateway
import com.meta_alert.prd.adapters.gateways.SlackGateway
import com.meta_alert.service.ScheduledEventService

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
            slackGateway.sendMessage("/teste", count)
        }
    }
}
