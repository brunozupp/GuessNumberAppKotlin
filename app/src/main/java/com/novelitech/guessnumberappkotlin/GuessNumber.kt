package com.novelitech.guessnumberappkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.novelitech.guessnumberappkotlin.components.display.Display
import com.novelitech.guessnumberappkotlin.components.KeyboardGuessNumbers
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun GuessNumber(modifier: Modifier = Modifier) {

    // Here I don't delegate the setter/getter to anyone by using the 'by' keyword because
    // I just want to use it to read and save its value when rendering the page
    var numberToGuess = remember {
        Random.nextInt(1, 7)
    }

    // Here I delegate the setter/getter to the remember because it will be the responsible for
    // retrieve and update the value from mutableIntStateOf
    var attemptsLeft by remember {
        mutableIntStateOf(3)
    }

    var winTheGame by remember {
        mutableStateOf<Boolean?>(null)
    }

    // Variables responsible for the Snackbar

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    println("The number I need to guess is $numberToGuess")

    fun playAgain() {
        winTheGame = null
        attemptsLeft = 3
        numberToGuess = Random.nextInt(1, 7)

        println("The new Guessing Number is $numberToGuess")
    }

    Scaffold(
        modifier = modifier
            .background(Color.White),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {

            // add weight modifier to the component composable to ensure
            // that the composable is measured after the other
            // composable is measured.
            Display(
                modifier = Modifier.weight(weight = 1.0f, fill = true),
                attemptsLeft = attemptsLeft,
                winTheGame = winTheGame,
                numberToGuess = numberToGuess,
                playAgain = {
                    playAgain()
                }
            )

            // This implies that, all composables with the weight modifier added to them will only
            // be measured after the composables that don’t use the weight modifier are measured.
            // That's why I don't need  to put the weight modifier, because it's height (from the
            // buttons) will be calculated first, so just the remaining height will be take in
            // consideration when calculating the measures in the weighted compasables
            KeyboardGuessNumbers(
                onTap = { number ->

                    attemptsLeft -= 1

                    if(number == numberToGuess) {

                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "You guessed correct. Number $numberToGuess is the guessing number.",
                                withDismissAction = true,
                            )
                        }

                        winTheGame = true
                    } else {

                        if(attemptsLeft > 0) {

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "You didn't guess the correct one, try again. $attemptsLeft attempts is left.",
                                    withDismissAction = true,
                                )
                            }

                        } else {

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "All your attempts were used, you LOST.",
                                    withDismissAction = true,
                                )
                            }

                            winTheGame = false
                        }
                    }
                }
            )
        }
    }


}