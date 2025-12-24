package com.example.codeforcesapp.codeforces.user.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto (
    val result: List<UserDto>
)