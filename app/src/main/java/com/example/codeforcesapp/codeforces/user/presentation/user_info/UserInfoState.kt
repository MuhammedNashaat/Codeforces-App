package com.example.codeforcesapp.codeforces.user.presentation.user_info

import androidx.compose.runtime.Immutable
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.presentation.models.UserUi

@Immutable
data class UserInfoState(
    val userUi: UserUi? = null,
    val isLoadingUserInfo: Boolean = false,

    val submission: List<Submission> = emptyList(),
    val isLoadingUserSubmissions: Boolean = false,
    val userSubmissionRating: MutableMap<Int,Int> = mutableMapOf<Int,Int>()

)
