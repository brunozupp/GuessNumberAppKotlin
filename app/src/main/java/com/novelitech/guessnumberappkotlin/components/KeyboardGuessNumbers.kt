package com.novelitech.guessnumberappkotlin.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun KeyboardGuessNumbers(
    modifier: Modifier = Modifier,
    onTap: (value: Int) -> Unit,
) {
    Column(modifier = modifier) {
        Row {
            for (i in 1..3)
                BoxNumber(
                    modifier = Modifier
                        .weight(1f),
                    number = i,
                    onTap,
                )
        }
        Row {
            for (i in 4..6)
                BoxNumber(
                    modifier = Modifier
                        .weight(1f),
                    number = i,
                    onTap,
                )
        }
    }
}