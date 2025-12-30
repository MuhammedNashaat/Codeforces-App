package com.example.codeforcesapp.codeforces.user.presentation.user_info

import androidx.compose.runtime.Immutable
import com.example.codeforcesapp.codeforces.contest.presentation.models.ContestUi
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.presentation.models.UserUi

@Immutable
data class UserInfoState(
    val userUi: UserUi? = null,
    val isLoading: Boolean = false,
    //val searchFieldHandle: String? = null
    val contestList: List<ContestUi>? = null, //for testing only
    val testSubmission: List<Submission>? = null,
    val counter800test: Int = 0
)
