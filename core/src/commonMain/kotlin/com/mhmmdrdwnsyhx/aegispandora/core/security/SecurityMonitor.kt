package com.mhmmdrdwnsyhx.aegispandora.core.security

import com.mhmmdrdwnsyhx.aegispandora.core.utils.getCurrentTimeMillis

object SecurityMonitor {
    private var failedAttempts = 0
    private val maxAttempts = 3
    private var timeoutUntil: Long? = null
    private const val timeoutDurationMillis = 5 * 60 * 1000L
    fun registerFailedAttempt() {
        failedAttempts++
        if (failedAttempts >= maxAttempts) {
            timeoutUntil = getCurrentTimeMillis() + timeoutDurationMillis
        }
    }

    fun clearAttempts() {
        failedAttempts = 0
        timeoutUntil = null
    }

    fun isLockedOut(): Boolean {
        val now = getCurrentTimeMillis()
        return timeoutUntil?.let { now < it } ?: false
    }

    fun getRemainingTimeoutMillis(): Long {
        val now = getCurrentTimeMillis()
        return timeoutUntil?.minus(now)?.coerceAtLeast(0) ?: 0
    }
}