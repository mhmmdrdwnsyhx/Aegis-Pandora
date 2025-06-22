package com.mhmmdrdwnsyhx.aegispandora.core.security

object VaultEncryptor {
    fun encrypt(input: String, key: String): String {
        // Dummy encryption: reverse + key salt
        return input.reversed() + key.take(2)
    }

    fun decrypt(input: String, key: String): String {
        // Dummy decryption: remove salt + reverse
        return input.dropLast(2).reversed()
    }
}