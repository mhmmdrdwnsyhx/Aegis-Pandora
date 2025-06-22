package com.mhmmdrdwnsyhx.aegispandora.core.security

object HashUtil {
    fun hashPassword(password: String): String {
        // Dummy hash: just reverse + static salt
        return password.reversed() + "_#SALT"
    }

    fun verifyPassword(input: String, hashed: String): Boolean {
        return hashPassword(input) == hashed
    }
}