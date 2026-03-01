package com.example.codeforcesapp.codeforces.user.domain

data class RatingChange(
    val contestId: Int,
    val contestName: String,
    val handle: String,
    val rank: Int,
    val ratingUpdateTimeSeconds: Int,
    val oldRating: Int,
    val newRating: Int
)
