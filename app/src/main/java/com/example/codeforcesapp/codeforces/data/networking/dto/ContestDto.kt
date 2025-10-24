package com.example.codeforcesapp.codeforces.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class ContestDto(
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
