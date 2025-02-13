package com.meta_alert.prd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling

class MetaAlertApplication

fun main(args: Array<String>) {
	println("Aplicação iniciada com sucesso!")
	runApplication<MetaAlertApplication>(*args)
}
