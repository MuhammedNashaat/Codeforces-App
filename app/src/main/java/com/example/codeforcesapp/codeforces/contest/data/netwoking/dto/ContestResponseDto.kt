package com.example.codeforcesapp.codeforces.contest.data.netwoking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ContestResponseDto (
    val result: List<ContestDto>
)