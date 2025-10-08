package com.example.codeforcesapp.codeforces.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto (
    val result: List<UserDto>
)