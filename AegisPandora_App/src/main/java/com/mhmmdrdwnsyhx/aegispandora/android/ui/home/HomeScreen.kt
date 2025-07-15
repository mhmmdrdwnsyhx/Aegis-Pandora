package com.mhmmdrdwnsyhx.aegispandora.android.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mhmmdrdwnsyhx.aegispandora.core.domain.VaultEntry

@Composable
fun HomeScreen(
    onEntrySelected: (VaultEntry) -> Unit,
    onLogout: () -> Unit
) {
    val sampleEntries = remember {
        mutableStateListOf(
            VaultEntry("1", "Google", "user1@gmail.com", "password1", null, System.currentTimeMillis()),
            VaultEntry("2", "Github", "user2", "password2", null, System.currentTimeMillis()),
            VaultEntry("3", "Facebook", "user3", "password3", null, System.currentTimeMillis())
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("My Vault", style = MaterialTheme.typography.titleLarge, color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))

        sampleEntries.forEach { entry ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onEntrySelected(entry) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(entry.label, style = MaterialTheme.typography.titleMedium)
                    Text("Username: ${entry.username}", color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onLogout, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Logout")
        }
    }
}
