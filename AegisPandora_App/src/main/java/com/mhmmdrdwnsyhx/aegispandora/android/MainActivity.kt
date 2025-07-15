package com.mhmmdrdwnsyhx.aegispandora.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.mhmmdrdwnsyhx.aegispandora.android.ui.detail.DetailScreen
import com.mhmmdrdwnsyhx.aegispandora.android.ui.home.HomeScreen
import com.mhmmdrdwnsyhx.aegispandora.android.ui.login.LoginScreen
import com.mhmmdrdwnsyhx.aegispandora.android.utils.PreferenceHelper
import com.mhmmdrdwnsyhx.aegispandora.core.domain.VaultEntry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var isAuthenticated by remember { mutableStateOf(false) }
                var selectedEntry by remember { mutableStateOf<VaultEntry?>(null) }

                when {
                    !isAuthenticated -> {
                        LoginScreen(
                            onPinSuccess = { isAuthenticated = true },
                            onVaultEjected = { isAuthenticated = false }
                        )
                    }
                    selectedEntry == null -> {
                        HomeScreen(
                            onEntrySelected = { entry -> selectedEntry = entry },
                            onLogout = {
                                PreferenceHelper.clear(this)
                                isAuthenticated = false
                            }
                        )
                    }
                    else -> {
                        DetailScreen(
                            entry = selectedEntry!!,
                            onSave = { updatedEntry ->
                                // Simpan ke storage (simulasi)
                                selectedEntry = updatedEntry
                            },
                            onDelete = {
                                // Delete logic (simulasi)
                                selectedEntry = null
                            },
                            onDuplicate = {
                                // Duplicate logic (simulasi)
                            },
                            onBack = {
                                selectedEntry = null
                            }
                        )
                    }
                }
            }
        }
    }
}
