package net.doemges.florentine.starter.logging.configuration

import net.doemges.florentine.starter.logging.LogManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class LogAutoConfiguration {
    @Bean
    fun logManager(): LogManager = LogManager()
}