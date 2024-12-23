package com.novelitech.guessnumberappkotlin.components.display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayLose(
    modifier: Modifier = Modifier,
    numberToGuess: Int,
    playAgain: () -> Unit,
    wrongAttempts: List<Int>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "OH NO :(",
            style = TextStyle(
                color = Color(0xFF521010),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
        Text(
            text = "You lost the game",
            style = TextStyle(
                color = Color(0xFF521010),
                fontSize = 24.sp,
            ),
        )
        Spacer(modifier = Modifier.size(24.dp))
        Text(text = "The guessing number was $numberToGuess.")
        Text(text = "Wrong attempts: ${wrongAttempts.joinToString(", ")}")
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            onClick = playAgain,
        ) {
            Text(text = "Play Again")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}