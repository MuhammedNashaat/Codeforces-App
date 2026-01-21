package com.example.codeforcesapp.codeforces.problems.presentation.models

import com.example.codeforcesapp.codeforces.problems.domain.Problem

data class ProblemUi(
    val contestId: Int? = null,
    val problemsetName: String = "",
    val index: String,
    val name: String,
    val type: String,
    val points: Float = 0f,
    val rating: Int? = null,
    val tags: List<String>
)

fun Problem.toProblemUi(): ProblemUi {
    return ProblemUi(
        contestId = this.contestId,
        problemsetName = this.problemsetName,
        index = this.index,
        name = this.name,
        type = this.type,
        points = this.points,
        rating = this.rating,
        tags = this.tags
    )
}