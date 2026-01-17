package com.example.codeforcesapp.codeforces.contest.presentation.contest_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesapp.ToastController
import com.example.codeforcesapp.codeforces.contest.domain.Contest
import com.example.codeforcesapp.codeforces.contest.presentation.models.toContestUi
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError
import com.example.codeforcesapp.codeforces.core.domain.util.Result
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
            //val result:Result<List<Contest>,NetworkError>
            when(val result = codeForcesAPI.getContestList()){
                is Result.Error -> {
                    ToastController.sendEvent(result.error)
                }
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            contestList = result.data.map { it.toContestUi() }
                        )
                    }
                }
            }
        }
    }
}
