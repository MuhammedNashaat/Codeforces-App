package com.example.codeforcesapp.codeforces.presentation.user_info

sealed interface UserInfoActions{
    data class OnSearchUserClick(val handle:String): UserInfoActions
}