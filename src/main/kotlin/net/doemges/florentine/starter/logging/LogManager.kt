package net.doemges.florentine.starter.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

class LogManager {
    val log: Logger = getLogger()

    init {
        log.info("LogManager started")
    }

    fun getLogger(): Logger {
        val clazz = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
            .callerClass
        return LoggerFactory.getLogger(clazz)
    }
}