package com.mhmmdrdwnsyhx.aegispandora.core.security

import com.mhmmdrdwnsyhx.aegispandora.core.device.EmailSimulator
import com.mhmmdrdwnsyhx.aegispandora.core.device.RebootSimulator
import com.mhmmdrdwnsyhx.aegispandora.core.device.SecureFolder
import com.mhmmdrdwnsyhx.aegispandora.core.session.UserInfoSession
import com.mhmmdrdwnsyhx.aegispandora.core.vault.VaultManager
import com.mhmmdrdwnsyhx.aegispandora.core.storage.LocalVaultManager

object EjectionController {
    fun ejectVaultBackup(password: String) {
        val encrypted = VaultManager.exportEncryptedVault(password)
        LocalVaultManager.saveEncryptedVault(encrypted)

        UserInfoSession.email?.let {
            EmailSimulator.sendVaultBackup(it, encrypted)
        }
        println("Vault backup prepared and sent.")
    }

    fun wipeVault() {
        VaultManager.clear()
        LocalVaultManager.clear()
        println("Vault wiped from memory and local storage.")
        RebootSimulator.simulateReboot()
    }

    fun handleCriticalBreach(password: String) {
        ejectVaultBackup(password)
        SecureFolder.storeFile("vault_backup.enc", VaultManager.exportEncryptedVault(password))
        wipeVault()
    }
}