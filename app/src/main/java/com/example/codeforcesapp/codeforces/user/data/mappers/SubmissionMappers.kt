package com.example.codeforcesapp.codeforces.user.data.mappers

import com.example.codeforcesapp.codeforces.problems.data.mappers.toProblem
import com.example.codeforcesapp.codeforces.user.data.networking.dto.SubmissionDto
import com.example.codeforcesapp.codeforces.user.domain.Submission

fun SubmissionDto.toSubmission():Submission{
    return Submission(
        id = this.id,
        contestId = this.contestId,
        creationTimeSeconds = this.creationTimeSeconds,
        relativeTimeSeconds = this.relativeTimeSeconds,
        problem = this.problem.toProblem(),
        programmingLanguage = this.programmingLanguage,
        verdict = this.verdict,
        testset = this.testset,
        passedTestCount = this.passedTestCount,
        timeConsumedMillis = this.timeConsumedMillis,
        memoryConsumedBytes = this.memoryConsumedBytes,
        points = this.points
    )
}