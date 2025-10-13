package com.example.codeforcesapp.codeforces.presentation.models

import com.example.codeforcesapp.codeforces.domain.User

data class UserUi(
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

fun User.toUserUi():UserUi{
    return UserUi(
        handle = this.handle,
        email = this.email,
        vkId = this.vkId,
        openId = this.openId,
        firstName = this.firstName,
        lastName = this.lastName,
        country = this.country,
        city = this.city,
        organization = this.organization,
        contribution = this.contribution,
        rank = this.rank,
        rating = this.rating,
        maxRank = this.maxRank,
        maxRating = this.maxRating,
        lastOnlineTimeSeconds = this.lastOnlineTimeSeconds,
        registrationTimeSeconds = this.registrationTimeSeconds,
        friendOfCount = this.friendOfCount,
        avatar = this.avatar,
        titlePhoto = this.titlePhoto
    )
}