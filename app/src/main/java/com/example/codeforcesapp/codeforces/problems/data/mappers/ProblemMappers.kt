package com.example.codeforcesapp.codeforces.problems.data.mappers

import com.example.codeforcesapp.codeforces.problems.data.networking.dto.ProblemDto
import com.example.codeforcesapp.codeforces.problems.domain.Problem

fun ProblemDto.toProblem(): Problem {
    return Problem(
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