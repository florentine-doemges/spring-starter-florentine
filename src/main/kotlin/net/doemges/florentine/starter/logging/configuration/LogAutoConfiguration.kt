package net.doemges.florentine.starter.logging.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import net.doemges.florentine.starter.logging.LogManager
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogAutoConfiguration {
    @Bean
    fun logManager(objectMapper: ObjectMapper): LogManager = LogManager(objectMapper)

    @Bean
    @ConditionalOnMissingBean(ObjectMapper::class)
    fun objectMapper(): ObjectMapper = ObjectMapper()
}