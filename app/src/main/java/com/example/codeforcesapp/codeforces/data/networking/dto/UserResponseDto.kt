package com.example.codeforcesapp.codeforces.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDto (
    val data: List<UserDto>
)