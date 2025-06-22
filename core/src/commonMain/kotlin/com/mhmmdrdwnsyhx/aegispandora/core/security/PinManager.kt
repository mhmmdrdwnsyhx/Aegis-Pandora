package com.mhmmdrdwnsyhx.aegispandora.core.security

object PinManager {
    private var storedPinHash: String? = null
    fun registerPin(pin: String) {
        require(pin.length == 8) { "PIN must be 8 digits" }
        storedPinHash = HashUtil.hashPassword(pin)
    }

    fun verifyPin(input: String): Boolean {
        return storedPinHash?.let {
            HashUtil.verifyPassword(input, it)
        } ?: false
    }

    fun isPinRegistered(): Boolean = storedPinHash != null
    fun resetPin() {
        storedPinHash = null
    }
}