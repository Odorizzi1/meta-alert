package com.meta_alert.prd.adapters.gateways

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SlackGateway(
    private val restTemplate: RestTemplate
) {

    fun sendMessage(webhookUrl: String, message: String) {
        val headers = HttpHeaders()
        headers.set("Content-Type", "application/json")

        val payload = mapOf(
            "text" to message
        )

        val request = HttpEntity(payload, headers)

        val response: ResponseEntity<String> = restTemplate.postForEntity(webhookUrl, request, String::class.java)

        if (!response.statusCode.is2xxSuccessful) {
            throw RuntimeException("Erro ao enviar mensagem ao Slack: ${response.body}")
        }
    }
}
