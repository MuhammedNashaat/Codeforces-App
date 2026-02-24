package com.example.codeforcesapp.codeforces.problems.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProblemDto(
    val contestId: Int? = null,
    val problemsetName: String = "",
    val index: String,
    val name: String,
    val type: String,
    val points: Float = 0f,
    val rating: Int = 0,
    val tags: List<String>
)
