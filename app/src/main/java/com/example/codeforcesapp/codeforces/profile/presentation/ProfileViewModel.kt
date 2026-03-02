package com.example.codeforcesapp.codeforces.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesapp.ToastController
import com.example.codeforcesapp.ToastEvent
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.core.domain.util.Result
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.presentation.models.toRatingChangeUi
import com.example.codeforcesapp.codeforces.user.presentation.models.toUserUi
import com.example.codeforcesapp.codeforces.user.presentation.user_info.UserInfoState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val codeForcesAPI: CodeForcesAPI,
    //should be shared Preference here
): ViewModel(){
    private val _state = MutableStateFlow(UserInfoState())
    val state = _state
        .onStart {
            getUserInfo  ("tourist")
            getUserStatus("tourist")
            getUserRating("tourist")
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            UserInfoState()
        )

    fun onAction(/*actions: ProfileActions*/){
        //when signUp
    }

    private fun getUserInfo(handles: String)
    {
        viewModelScope.launch {
            _state.update { it.copy(isLoadingUserInfo = true) }
            when(val result = codeForcesAPI.getUser(handles = handles)){
                is Result.Error -> {
                    ToastController.sendEvent(ToastEvent.KtorError(event = result.error))
                }
                is Result.Success->{
                    _state.update {
                        it.copy(
                            isLoadingUserInfo = false,
                            userUi = result.data.toUserUi()
                        )
                    }
                }
            }
        }
    }

    private fun calculateRating(submissions: List<Submission>):MutableMap<Int,Int>
    {
        val ratingMap: MutableMap<Int,Int> = mutableMapOf()
        for ( i in submissions) {
            if(i.verdict == "OK"  && i.problem.rating != 0) {
                ratingMap[i.problem.rating] = ratingMap.getOrDefault(i.problem.rating,0) +1
            }
        }
        return ratingMap
    }

    private fun getUserStatus(handles: String)
    {
        viewModelScope.launch {
            _state.update { it.copy(isLoadingUserSubmissions = true) }
            when(val result = codeForcesAPI.getUserStatus(handles = handles)){
                is Result.Error -> {
                    ToastController.sendEvent(ToastEvent.KtorError(event = result.error))
                }
                is Result.Success->{
                    _state.update {
                        it.copy(
                            isLoadingUserSubmissions = false,
                            submission = result.data, // should be List<SubmissionUi>
                        )
                    }
                    _state.update {
                        it.copy(
                            userSubmissionRating = calculateRating(it.submission)
                        )
                    }
                }
            }
        }
    }

    private fun getUserRating(handles: String)
    {
        viewModelScope.launch {
            _state.update { it.copy(isLoadingRatingChange = true) }
            when(val result = codeForcesAPI.getUserRating(handles = handles)){
                is Result.Error -> {
                    ToastController.sendEvent(ToastEvent.KtorError(event = result.error))
                }
                is Result.Success->{
                    _state.update {
                        it.copy(
                            isLoadingRatingChange = false,
                            ratingChangeUi = result.data.map { it.toRatingChangeUi() }.reversed()
                        )
                    }
                }
            }
        }
    }
}