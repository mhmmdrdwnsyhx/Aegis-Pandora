import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onPinEntered: (String) -> Unit
) {
    var pinInput by remember { mutableStateOf("") }
    val gradient = Brush.linearGradient(colors = listOf(Color(0xFFFFA726), Color(0xFFE91E63)))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2F2B45)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Clock and label
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "12.00",
                fontSize = 50.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Enter Passcode",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
        }

        // Dashes (PIN indicator)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(6) { index ->
                Box(
                    modifier = Modifier
                        .size(16.dp, 2.dp)
                        .background(
                            if (index < pinInput.length) Color.White else Color.White.copy(alpha = 0.3f)
                        )
                )
            }
        }

        // Keypad
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            val keys = listOf(
                listOf("1", "2", "3"),
                listOf("4", "5", "6"),
                listOf("7", "8", "9"),
                listOf("", "0", "")
            )

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
                                    .size(70.dp)
                                    .background(brush = gradient, shape = CircleShape)
                                    .clickable {
                                        if (pinInput.length < 6) pinInput += key
                                    }
                            ) {
                                Text(
                                    text = key,
                                    style = TextStyle(fontSize = 24.sp, color = Color.White)
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.size(70.dp))
                        }
                    }
                }
            }
        }
        Button(
            onClick = {
                onPinEntered(pinInput)
                pinInput = ""
            },
            enabled = pinInput.length == 6
        ) {
            Text("Submit")
        }
    }
}
