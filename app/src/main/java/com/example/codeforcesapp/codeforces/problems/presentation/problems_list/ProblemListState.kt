package com.example.codeforcesapp.codeforces.problems.presentation.problems_list

import androidx.compose.runtime.Immutable
import com.example.codeforcesapp.codeforces.problems.presentation.models.ProblemUi

@Immutable
data class ProblemListState(
    val isLoading: Boolean = true,
    val problemList: List<ProblemUi>? = null
)
