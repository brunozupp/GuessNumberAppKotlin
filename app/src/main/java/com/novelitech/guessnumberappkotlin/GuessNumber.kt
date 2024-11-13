package com.novelitech.guessnumberappkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.novelitech.guessnumberappkotlin.components.BoxNumber
import com.novelitech.guessnumberappkotlin.components.DisplayInformation
import com.novelitech.guessnumberappkotlin.components.KeyboardGuessNumbers
import kotlin.random.Random

@Composable
fun GuessNumber(modifier: Modifier = Modifier) {

    val numberToGuess = remember {
        Random.nextInt(1, 7)
    }

    var attemptsLeft by remember {
        mutableIntStateOf(3)
    }

    println("The number I need to guess is $numberToGuess")

    Scaffold(
        modifier = modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {

            // add weight modifier to the component composable to ensure
            // that the composable is measured after the other
            // composable is measured.
            DisplayInformation(
                modifier = Modifier.weight(weight = 1.0f, fill = true),
                attemptsLeft = attemptsLeft
            )

            // This implies that, all composables with the weight modifier added to them will only
            // be measured after the composables that don’t use the weight modifier are measured.
            // That's why I don't need  to put the weight modifier, because it's height (from the
            // buttons) will be calculated first, so just the remaining height will be take in
            // consideration when calculating the measures in the weighted compasables
            KeyboardGuessNumbers(
                onTap = { number ->

                    attemptsLeft -= 1

//                    if(number == numberToGuess) {
//                        // State Success
//                    } else {
//
//                        if(attemptsLeft > 0) {
//                            // Show Error Guess and Try Again
//                        } else {
//                            // Show Error State
//                        }
//                    }
                }
            )
        }
    }
}