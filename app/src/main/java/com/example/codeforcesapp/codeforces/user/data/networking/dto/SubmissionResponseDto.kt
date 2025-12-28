package com.example.codeforcesapp.codeforces.user.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class SubmissionResponseDto (
    val result: List<SubmissionDto>
)