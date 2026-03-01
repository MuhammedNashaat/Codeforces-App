package com.example.codeforcesapp.codeforces.user.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatingChangeDto(
    val contestId: Int,
    val contestName: String,
    val handle: String,
    val rank: Int,
    val ratingUpdateTimeSeconds: Int,
    val oldRating: Int,
    val newRating: Int
)
