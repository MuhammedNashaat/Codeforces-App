package com.example.codeforcesapp.codeforces.user.presentation

import androidx.compose.ui.graphics.Color
import com.example.codeforcesapp.ui.theme.Orange
import com.example.codeforcesapp.ui.theme.Violet

fun colorRating(rating: Int ):Color
{
    if (rating < 1200) return Color.Gray
    if (rating < 1400) return Color.Green
    if (rating < 1600) return Color.Cyan
    if (rating < 1900) return Color.Blue
    if (rating < 2200) return Violet
    if (rating < 2400) return Orange
    else return Color.Red
}