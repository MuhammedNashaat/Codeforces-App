package com.example.codeforcesapp.codeforces.user.data.networking.dto

import com.example.codeforcesapp.codeforces.problems.data.networking.dto.ProblemDto
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionDto (
    val id: Int,
    val contestId: Int? = null,
    val creationTimeSeconds: Int, //should be unix
    val relativeTimeSeconds: Int,
    val problem: ProblemDto,
    //val author:Party
    val programmingLanguage: String,
    val verdict: String = "", //should be enum
    val testset: String = "", //should be enum
    val passedTestCount: Int,
    val timeConsumedMillis: Int, //should be unix
    val memoryConsumedBytes: Int,
    val points: Float? = null
)