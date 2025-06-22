package com.mhmmdrdwnsyhx.aegispandora.core.device

object EmailSimulator {
    fun sendVaultBackup(to: String, encryptedData: String) {
        println("Simulating sending vault backup to $to")
        println("Vault content: $encryptedData")
    }
}