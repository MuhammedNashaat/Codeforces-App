package com.example.codeforcesapp.codeforces.data.mappers

import com.example.codeforcesapp.codeforces.data.networking.dto.UserDto
import com.example.codeforcesapp.codeforces.domain.User

fun UserDto.toUser():User{
    return User(
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