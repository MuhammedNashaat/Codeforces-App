package com.example.codeforcesapp.codeforces.user.data.mappers

import com.example.codeforcesapp.codeforces.user.data.networking.dto.ProblemDto
import com.example.codeforcesapp.codeforces.user.domain.Problem

fun ProblemDto.toProblem():Problem{
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