package net.doemges.florentine.starter.logging.configuration

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(SCOPE_PROTOTYPE)
class LogManager {
    final val log: Logger = getLogger()

    init {
        log.info("LogManager started")
    }

    final fun getLogger(): Logger {
        val clazz = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
            .callerClass
        return LoggerFactory.getLogger(clazz)
    }
}