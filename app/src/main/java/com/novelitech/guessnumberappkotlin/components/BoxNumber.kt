package com.novelitech.guessnumberappkotlin.components

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
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
fun BoxNumber(
    modifier: Modifier = Modifier,
    number: Int,
    onTap: (value: Int) -> Unit,
    applyOpacity: Boolean = false,
    disabled: Boolean = false,
) {
    Box(
        modifier = modifier
            .height(150.dp)
            .background(Color(0xFFe3e1de))
            .background(Color.Black.copy(alpha = if (applyOpacity) 0.7f else 0.0f))
            .border(
                width = 1.dp,
                Color.Black,
            )
            .clickable(
                enabled = !disabled,
            ) {
                onTap(number)
            }
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "$number",
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )
        )
    }
}