package com.example.codeforcesapp.codeforces.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val handle: String,
    val email: String,
    val vkId: String,
    val openId: String,
    val firstName: String,
    val lastName: String,
    val country: String,
    val city: String,
    val organization: String,
    val contribution: Int,
    val rank: String,
    val rating: Int,
    val maxRank: String,
    val maxRating: Int,
    val lastOnlineTimeSeconds: Int,
    val registrationTimeSeconds: Int,
    val friendOfCount: Int,
    val avatar: String,
    val titlePhoto: String
)
