package com.mhmmdrdwnsyhx.aegispandora.core.domain

import kotlinx.serialization.Serializable

@Serializable
data class VaultEntry(
    val id: String,
    val label: String,
    val username: String,
    val password: String,
    val notes: String? = null,
    val lastUpdated: Long = 0L
)