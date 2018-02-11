package com.slobevg.simplespin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SimpleSpinApplication

fun main(args: Array<String>) {
    runApplication<SimpleSpinApplication>(*args)
}
