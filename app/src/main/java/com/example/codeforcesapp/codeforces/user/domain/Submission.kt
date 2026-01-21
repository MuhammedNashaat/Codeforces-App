package com.example.codeforcesapp.codeforces.user.domain

import com.example.codeforcesapp.codeforces.problems.domain.Problem

data class Submission (
    val id: Int,
    val contestId: Int? = null,
    val creationTimeSeconds: Int, //should be unix
    val relativeTimeSeconds: Int,
    val problem: Problem,
    //val author:Party
    val programmingLanguage: String,
    val verdict: String = "", //should be enum
    val testset: String = "", //should be enum
    val passedTestCount: Int,
    val timeConsumedMillis: Int, //should be unix
    val memoryConsumedBytes: Int,
    val points: Float? = null
)