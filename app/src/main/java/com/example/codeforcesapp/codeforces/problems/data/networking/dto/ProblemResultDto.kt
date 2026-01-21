package com.example.codeforcesapp.codeforces.problems.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProblemResultDto(
    val problems: List<ProblemDto>,
    //val problemStatistics: List<>
)