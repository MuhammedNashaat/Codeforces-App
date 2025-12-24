package com.example.codeforcesapp.codeforces.contest.presentation.models

import com.example.codeforcesapp.codeforces.contest.domain.Contest

data class ContestUi (
    val id: Int,
    val name: String,
    val type: String,
    val phase: String,
    val frozen: Boolean,
    val durationSeconds: Int,
    val freezeDurationSeconds: Int? = null,
    val startTimeSeconds: Int? = null,
    val relativeTimeSeconds: Int? = null,
    val preparedBy: String? = null,
    val websiteUrl: String? = null,
    val description: String? = null,
    val difficulty: Int? = null, //from 1 to 5 Larger the harder
    val kind: String? = null,
    val icpcRegion: String? = null,
    val country: String? = null,
    val city: String? = null,
    val season: String? = null
)

fun Contest.toContestUi(): ContestUi {
    return ContestUi(
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