package com.example.codeforcesapp.codeforces.user.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatingChangeResponseDto(
    val result: List<RatingChangeDto>
)
