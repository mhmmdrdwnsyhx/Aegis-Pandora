package com.mhmmdrdwnsyhx.aegispandora.android.utils

import android.content.Context
import androidx.core.content.edit
import org.mindrot.jbcrypt.BCrypt

object PreferenceHelper {
    private const val PREF_NAME = "aegis_prefs"
    private const val KEY_PIN_HASH = "pin_hash"

    fun savePin(context: Context, pin: String) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val hash = BCrypt.hashpw(pin, BCrypt.gensalt())
        prefs.edit { putString(KEY_PIN_HASH, hash) }
    }

    fun verifyPin(context: Context, pin: String): Boolean {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val hash = prefs.getString(KEY_PIN_HASH, null) ?: return false
        return BCrypt.checkpw(pin, hash)
    }

    fun clear(context: Context) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit { clear() }
    }
}