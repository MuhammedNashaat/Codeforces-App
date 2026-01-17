package com.example.codeforcesapp.codeforces.core.domain

import com.example.codeforcesapp.codeforces.contest.domain.Contest
import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError
import com.example.codeforcesapp.codeforces.core.domain.util.Result
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.domain.User

interface CodeForcesAPI {
    suspend fun getUser(handles: String) : Result<User,NetworkError>
    suspend fun getContestList():Result<List<Contest>,NetworkError>
    suspend fun getUserStatus(handles: String): List<Submission>
}