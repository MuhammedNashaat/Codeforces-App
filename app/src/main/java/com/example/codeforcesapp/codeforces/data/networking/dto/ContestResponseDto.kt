package com.example.codeforcesapp.codeforces.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ContestResponseDto (
    val result: List<ContestDto>
)