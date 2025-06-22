package com.mhmmdrdwnsyhx.aegispandora.core.storage

actual object LocalVaultManager {
    private var vault: String? = null
    actual fun saveEncryptedVault(data: String) {
        vault = data
        // TODO: Replace with secure storage logic later
    }

    actual fun loadEncryptedVault(): String? {
        return vault
    }

    actual fun clear() {
        vault = null
    }
}