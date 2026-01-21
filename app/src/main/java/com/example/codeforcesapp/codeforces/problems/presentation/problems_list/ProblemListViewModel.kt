package com.example.codeforcesapp.codeforces.problems.presentation.problems_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesapp.ToastController
import com.example.codeforcesapp.ToastEvent
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.core.domain.util.Result
import com.example.codeforcesapp.codeforces.problems.presentation.models.toProblemUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProblemListViewModel(
    private val codeForcesAPI:CodeForcesAPI
):ViewModel() {
    val test:List<String> = listOf("");
    private val _state = MutableStateFlow(ProblemListState())
    val state = _state
        .onStart { getProblemList(test) }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ProblemListState()
        )

    private fun getProblemList(tags: List<String>){
        viewModelScope.launch {
            when (val result = codeForcesAPI.getProblemsSet(tags)){
                is Result.Error -> {
                    ToastController.sendEvent(ToastEvent.KtorError(event = result.error))
                }
                is Result.Success -> {
                    _state.update {
                        it.copy(
                            isLoading = true,
                            problemList = result.data.map {it.toProblemUi()}
                        )
                    }
                }
            }
        }
    }
}