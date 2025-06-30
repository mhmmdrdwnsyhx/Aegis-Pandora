package com.mhmmdrdwnsyhx.aegispandora.android.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmmdrdwnsyhx.aegispandora.android.R
import com.mhmmdrdwnsyhx.aegispandora.android.utils.PreferenceHelper

@Composable
fun LoginScreen(
    onPinSuccess: () -> Unit,
    onVaultEjected: () -> Unit
) {
    var pinInput by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }
    var failCounter by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_wave),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(600.dp)
                        .height(150.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.glass_clock),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "12.00",
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = "Enter Passcode",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(600.dp)
                        .height(68.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.glass_input),
                        contentDescription = null,
                        modifier = Modifier.matchParentSize()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp)
                            .align(Alignment.Center),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        repeat(6) { index ->
                            Box(
                                modifier = Modifier
                                    .width(24.dp)
                                    .height(2.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.onBackground.copy(
                                            alpha = if (index < pinInput.length) 1f else 0.3f
                                        )
                                    )
                            )
                        }
                    }
                }

                if (errorText.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = errorText,
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            val keys = listOf(
                listOf("1", "2", "3"),
                listOf("4", "5", "6"),
                listOf("7", "8", "9"),
                listOf("", "0", "")
            )

            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                keys.forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEach { key ->
                            if (key.isNotEmpty()) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(75.dp)
                                        .clickable {
                                            if (pinInput.length < 6) pinInput += key
                                        }
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.glass_circle),
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                    Text(
                                        text = key,
                                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                            } else {
                                Spacer(modifier = Modifier.size(75.dp))
                            }
                        }
                    }
                }
            }

            Button(
                onClick = {
                    if (PreferenceHelper.verifyPin(context, pinInput)) {
                        errorText = ""
                        failCounter = 0
                        onPinSuccess()
                    } else {
                        failCounter++
                        errorText = "PIN salah. Percobaan: $failCounter"

                        if (failCounter >= 3) {
                            PreferenceHelper.clear(context)
                            errorText = "Vault ejected. App akan direset."
                            onVaultEjected()
                        }
                    }
                    pinInput = ""
                },
                enabled = pinInput.length == 6,
                modifier = Modifier
                    .alpha(if (pinInput.length == 6) 1f else 0.5f)
                    .padding(top = 8.dp)
            ) {
                Text("Submit")
            }
        }
    }
}