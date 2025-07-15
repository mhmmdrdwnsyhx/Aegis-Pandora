package com.mhmmdrdwnsyhx.aegispandora.android.ui.edit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mhmmdrdwnsyhx.aegispandora.core.domain.VaultEntry
import com.mhmmdrdwnsyhx.aegispandora.core.utils.currentEpochSeconds

@Composable
fun EditVaultScreen(
    existingEntry: VaultEntry? = null,
    onSave: (VaultEntry) -> Unit,
    onCancel: () -> Unit
) {
    var label by remember { mutableStateOf(existingEntry?.label ?: "") }
    var username by remember { mutableStateOf(existingEntry?.username ?: "") }
    var password by remember { mutableStateOf(existingEntry?.password ?: "") }
    var notes by remember { mutableStateOf(existingEntry?.notes ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = if (existingEntry == null) "Tambah Entry" else "Edit Entry",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.onBackground
        )

        OutlinedTextField(
            value = label,
            onValueChange = { label = it },
            label = { Text("Label") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onCancel,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Batal")
            }

            Button(
                onClick = {
                    val newEntry = VaultEntry(
                        id = existingEntry?.id ?: generateId(),
                        label = label,
                        username = username,
                        password = password,
                        notes = notes,
                        lastUpdated = currentEpochSeconds()
                    )
                    onSave(newEntry)
                },
                enabled = label.isNotBlank() && password.isNotBlank()
            ) {
                Text("Simpan")
            }
        }
    }
}
// Dummy ID generator
fun generateId(): String = "id_" + System.currentTimeMillis().toString()