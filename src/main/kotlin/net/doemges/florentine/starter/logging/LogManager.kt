package net.doemges.florentine.starter.logging

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogManager(
    private val objectMapper: ObjectMapper
) : HasLogger {

    private val classMap: MutableMap<Class<*>, Logger> = mutableMapOf()

    init {
        info { "LogManager started" }
        info { this }
    }

    override val logManager: LogManager
        get() = this

    override fun getLogger(): Logger = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
        .callerClass.let { clazz -> classMap[clazz] ?: LoggerFactory.getLogger(clazz).also { classMap[clazz] = it } }

    fun <T : HasLogger, F> T.info(block: (T) -> F): T {
        return block(this).also {
            when (it) {
                is String -> getLogger().info(it)
                else -> getLogger().info(objectMapper.writeValueAsString(it))
            }
        }.let { this }
    }
}

interface HasLogger {
    val logManager:LogManager
    fun getLogger(): Logger = logManager.getLogger()
}



