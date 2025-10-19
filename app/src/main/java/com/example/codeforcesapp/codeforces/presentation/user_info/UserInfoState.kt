package com.example.codeforcesapp.codeforces.presentation.user_info

import androidx.compose.runtime.Immutable
import com.example.codeforcesapp.codeforces.presentation.models.UserUi

@Immutable
data class UserInfoState(
    val userUi: UserUi? = null,
    val isLoading: Boolean = false,
    //val searchFieldHandle: String? = null
)
