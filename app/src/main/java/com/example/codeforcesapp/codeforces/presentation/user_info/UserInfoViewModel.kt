package com.example.codeforcesapp.codeforces.presentation.user_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeforcesapp.codeforces.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.presentation.models.toUserUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserInfoViewModel(
    private val codeForcesAPI: CodeForcesAPI
): ViewModel(){
    private val _state = MutableStateFlow(UserInfoState())
    val state = _state
        .onStart {  }

    fun onAction(actions: UserInfoActions){
        when (actions){
            is UserInfoActions.OnSearchUserClick -> {
                getUserInfo(actions.handle)
            }
        }
    }

    private fun getUserInfo(handles: String){
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            _state.update { it.copy(isLoading = false,
                userUi = codeForcesAPI.getUser(handles = handles).toUserUi()
                ) }
        }
    }
}