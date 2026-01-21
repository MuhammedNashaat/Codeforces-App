package com.example.codeforcesapp.codeforces.problems.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProblemSetResponseDto(
    val result: ProblemResultDto
)