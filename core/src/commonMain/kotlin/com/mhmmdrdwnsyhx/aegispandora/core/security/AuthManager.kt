package com.mhmmdrdwnsyhx.aegispandora.core.security

import com.mhmmdrdwnsyhx.aegispandora.core.session.UserInfoSession

object AuthManager {
    private var storedHash: String? = null
    fun registerMasterPassword(password: String) {
        storedHash = HashUtil.hashPassword(password)
    }

    fun isMasterPasswordCorrect(input: String): Boolean {
        return storedHash?.let {
            HashUtil.verifyPassword(input, it)
        } ?: false
    }

    fun setupUserCredentials(email: String, username: String, question: String, answer: String) {
        UserInfoSession.email = email
        UserInfoSession.username = username
        UserInfoSession.setRecoveryData(question, answer)
    }

    fun completeRegistration(pin: String, email: String, username: String, question: String, answer: String) {
        PinManager.registerPin(pin)
        setupUserCredentials(email, username, question, answer)
    }

    fun recoverPassword(answer: String): Boolean {
        return UserInfoSession.verifyRecoveryAnswer(answer)
    }

    fun hasMasterPassword(): Boolean = storedHash != null
    fun resetVault() {
        storedHash = null
    }
}