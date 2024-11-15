package com.novelitech.guessnumberappkotlin.components.display

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DisplayWin(
    modifier: Modifier = Modifier,
    numberToGuess: Int,
    attemptsLeft: Int,
    playAgain: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "Win")
    }
}