package com.example.codeforcesapp.codeforces.user.domain

data class User(
    val handle: String,
    val email: String = "",
    val vkId: String = "",
    val openId: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val country: String = "",
    val city: String = "",
    val organization: String = "",
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
/*
lastOnline and registration TimeSeconds are unix time format -> needs to be change
 */