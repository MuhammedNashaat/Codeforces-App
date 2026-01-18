package com.example.codeforcesapp.codeforces.user.presentation.user_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesapp.ToastController
import com.example.codeforcesapp.ToastEvent
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.contest.presentation.models.toContestUi
import com.example.codeforcesapp.codeforces.core.domain.util.Result
import com.example.codeforcesapp.codeforces.core.domain.util.onError
import com.example.codeforcesapp.codeforces.core.domain.util.onSuccess
import com.example.codeforcesapp.codeforces.core.presentation.util.errorToString
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.presentation.models.toUserUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserInfoViewModel(
    private val codeForcesAPI: CodeForcesAPI
): ViewModel(){
    private val _state = MutableStateFlow(UserInfoState())
    val state = _state

    fun onAction(actions: UserInfoActions){
        when (actions){
            is UserInfoActions.OnSearchUserClick -> {
                getUserInfo(actions.handle)
            }
        }
    }

    private fun getUserInfo(handles: String)
    {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when(val result = codeForcesAPI.getUser(handles = handles)){
                is Result.Error -> {
                    ToastController.sendEvent(ToastEvent.KtorError(event = result.error))
                }
                is Result.Success->{
                    _state.update {
                        it.copy(
                            isLoading = false,
                            userUi = result.data.toUserUi()
                        )
                    }
                }
            }
        }
    }

    private fun calc800Testing(submissions:List<Submission>?):Int
    {
        var counter = 0
        if (submissions != null) {
            for ( i in submissions)
            {
                if(i.problem.rating == 900 && i.verdict == "OK" )
                    counter++
            }
        }

        return counter
    }
}