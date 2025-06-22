package com.mhmmdrdwnsyhx.aegispandora.core.utils

import kotlinx.datetime.Clock

actual fun getCurrentTimeMillis(): Long = Clock.System.now().toEpochMilliseconds()