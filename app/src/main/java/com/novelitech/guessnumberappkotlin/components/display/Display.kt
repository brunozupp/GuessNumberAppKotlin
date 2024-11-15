package com.novelitech.guessnumberappkotlin.components.display

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Display(
    modifier: Modifier = Modifier,
    numberToGuess: Int,
    attemptsLeft: Int,
    winTheGame: Boolean?,
    playAgain: () -> Unit,
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ){

            Spacer(
                modifier = Modifier.size(24.dp)
            )

            when(winTheGame) {
                true -> DisplayWin(
                    attemptsLeft = attemptsLeft,
                    playAgain = playAgain,
                    numberToGuess = numberToGuess,
                )
                false -> DisplayLose(
                    numberToGuess = numberToGuess,
                    playAgain = playAgain,
                )
                null -> DisplayGame(attemptsLeft = attemptsLeft)
            }
        }
    }
}