package com.example.codeforcesapp.codeforces.user.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextRank(
    text: String,
    rating: Int,
    modifier: Modifier = Modifier,
    fontSize: TextUnit
) {
    val color = colorRating(rating)
    if(rating >= 2900)
    {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black))
                {
                    append(text[0])
                }
                withStyle(style = SpanStyle(color = Color.Red))
                {
                    append(text.drop(1))
                }
            },
            modifier = modifier,
            fontSize = fontSize
        )
    }
    else
    {
        Text(
            text = text,
            color = color,
            modifier = modifier,
            fontSize = fontSize
        )
    }
}