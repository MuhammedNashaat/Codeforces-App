package com.example.codeforcesapp.codeforces.contest.presentation.contest_list

import androidx.compose.runtime.Immutable
import com.example.codeforcesapp.codeforces.contest.presentation.models.ContestUi

@Immutable
data class ContestListState(
    val isLoading: Boolean = false,
    val contestList: List<ContestUi>? = null
)