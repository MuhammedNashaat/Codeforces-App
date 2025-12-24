package com.example.codeforcesapp.codeforces.contest.data.mappers

import com.example.codeforcesapp.codeforces.contest.data.netwoking.dto.ContestDto
import com.example.codeforcesapp.codeforces.contest.domain.Contest

fun ContestDto.toContest(): Contest {
    return Contest(
        id = this.id,
        name = this.name,
        type = this.type,
        phase = this.phase,
        frozen = this.frozen,
        durationSeconds = this.durationSeconds,
        freezeDurationSeconds = this.freezeDurationSeconds,
        startTimeSeconds = this.startTimeSeconds,
        relativeTimeSeconds = this.relativeTimeSeconds,
        preparedBy = this.preparedBy,
        websiteUrl = this.websiteUrl,
        description = this.description,
        difficulty = this.difficulty,
        kind = this.kind,
        icpcRegion = this.icpcRegion,
        country = this.country,
        city = this.city,
        season = this.season
    )
}