package com.mhmmdrdwnsyhx.aegispandora.android

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.mhmmdrdwnsyhx.aegispandora.ui.test

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        onPinEntered = { pin ->
                            println("PIN Entered: $pin")
                            // TODO: Integrasikan dengan VaultSession.tryUnlockWithPin(pin)
                        }
                    )
                }
            }
        }
    }
}
