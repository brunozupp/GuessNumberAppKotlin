package com.novelitech.guessnumberappkotlin.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayInformation(
    modifier: Modifier = Modifier,
    attemptsLeft: Int,
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

            Text(
                text = "Guess Number Game",
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Spacer(
                modifier = Modifier.size(24.dp)
            )

            //Text(text = "Corrected guesses: 2")
            //Text(text = "Wrong guesses: 2")
            Text(text = "Total attempts left: $attemptsLeft")

            Spacer(
                modifier = Modifier.weight(weight = 1.0f)
            )

            Text(
                text = "Now, try to guess what number it is!",
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
            Text(
                text = "?",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            Spacer(
                modifier = Modifier.weight(weight = 1.0f)
            )
        }
    }
}