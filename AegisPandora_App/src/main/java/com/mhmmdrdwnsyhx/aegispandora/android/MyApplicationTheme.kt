package com.mhmmdrdwnsyhx.aegispandora.android

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            background = Color(0xFF2F2B45),
            onBackground = Color.White,
        ),
        content = content
    )
}