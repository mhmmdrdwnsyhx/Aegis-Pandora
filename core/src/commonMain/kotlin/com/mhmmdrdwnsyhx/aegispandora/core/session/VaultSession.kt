package com.mhmmdrdwnsyhx.aegispandora.core.session

import com.mhmmdrdwnsyhx.aegispandora.core.security.AuthManager
import com.mhmmdrdwnsyhx.aegispandora.core.security.EjectionController
import com.mhmmdrdwnsyhx.aegispandora.core.security.PinManager
import com.mhmmdrdwnsyhx.aegispandora.core.security.SecurityMonitor
import com.mhmmdrdwnsyhx.aegispandora.core.storage.LocalVaultManager
import com.mhmmdrdwnsyhx.aegispandora.core.vault.VaultManager

object VaultSession {
    var isUnlocked = false
        private set
    fun tryUnlock(password: String): Boolean {
        val success = AuthManager.isMasterPasswordCorrect(password)
        if (success) {
            LocalVaultManager.loadEncryptedVault()?.let {
                VaultManager.importEncryptedVault(it, password)
            }
            isUnlocked = true
        }
        return success
    }

    fun register(password: String) {
        AuthManager.registerMasterPassword(password)
        val encrypted = VaultManager.exportEncryptedVault(password)
        LocalVaultManager.saveEncryptedVault(encrypted)
        isUnlocked = true
    }

    fun logout() {
        isUnlocked = false
    }

    fun getVaultData(): String? {
        return if (isUnlocked) {
            VaultManager.exportEncryptedVault("userKey123")
        } else null
    }

    fun tryUnlockWithPin(pin: String): Boolean {
        if (SecurityMonitor.isLockedOut()) {
            println("App is temporarily locked.")
            return false
        }
        val success = PinManager.verifyPin(pin)
        if (success) {
            isUnlocked = true
            SecurityMonitor.clearAttempts()
            LocalVaultManager.loadEncryptedVault()?.let {
                VaultManager.importEncryptedVault(it, pin)
            }
        } else {
            SecurityMonitor.registerFailedAttempt()
            if (SecurityMonitor.isLockedOut()) {
                EjectionController.handleCriticalBreach(pin)
            }
        }
        return success
    }
}