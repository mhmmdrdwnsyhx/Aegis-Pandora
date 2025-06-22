package com.mhmmdrdwnsyhx.aegispandora.core.storage

expect object LocalVaultManager {
    fun saveEncryptedVault(data: String)
    fun loadEncryptedVault(): String?
    fun clear()
}