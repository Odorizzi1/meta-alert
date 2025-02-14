package com.meta_alert.prd.adapter.gateways


import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class MetabaseGateway(
    private val restTemplate: RestTemplate
) {

    fun fetchData(queryId: String): String {
        val url = "https://metabase.example.com/api/card/$queryId/query"

        return restTemplate.getForObject(url, String::class.java)
            ?: throw RuntimeException("Erro ao consultar a API do Metabase")
    }
}
