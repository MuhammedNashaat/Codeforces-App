package com.example.codeforcesapp.codeforces.contest.presentation.contest_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesapp.codeforces.contest.presentation.models.toContestUi
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContestListViewModel(
    private val codeForcesAPI: CodeForcesAPI
):ViewModel() {
    private val _state = MutableStateFlow(ContestListState())
    val state = _state
        .onStart { getContestList() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ContestListState()
        )


    private fun getContestList(){
        viewModelScope.launch {
            _state.update { it.copy(
                contestList = codeForcesAPI.getContestList().map { it.toContestUi() },
            ) }
        }
    }
}
