package com.mhmmdrdwnsyhx.aegispandora.core.vault

import com.mhmmdrdwnsyhx.aegispandora.core.domain.VaultEntry
import com.mhmmdrdwnsyhx.aegispandora.core.security.VaultEncryptor
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object VaultManager {
    private val vaultData = mutableListOf<VaultEntry>()
    fun addEntry(entry: VaultEntry) {
        vaultData.add(entry)
    }

    fun getAllEntries(): List<VaultEntry> {
        return vaultData.toList()
    }

    fun exportEncryptedVault(key: String): String {
        val json = Json.encodeToString(vaultData)
        return VaultEncryptor.encrypt(json, key)
    }

    fun importEncryptedVault(encrypted: String, key: String) {
        val decrypted = VaultEncryptor.decrypt(encrypted, key)
        val decoded = Json.decodeFromString<List<VaultEntry>>(decrypted)
        vaultData.clear()
        vaultData.addAll(decoded)
    }

    fun clear() {
        vaultData.clear()
    }
}