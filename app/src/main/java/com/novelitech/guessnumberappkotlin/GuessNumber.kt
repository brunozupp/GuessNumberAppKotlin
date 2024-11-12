package com.novelitech.guessnumberappkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GuessNumber(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Box {
                Column {
                    Text(text = "View information here")
                }
            }
            Spacer(modifier = Modifier)
            Row {
                for (i in 1..3)
                    Box {
                        Text(text = "$i")
                    }
            }
            Row {
                for (i in 1..3)
                    Box {
                        Text(text = "$i")
                    }
            }
        }
    }
}