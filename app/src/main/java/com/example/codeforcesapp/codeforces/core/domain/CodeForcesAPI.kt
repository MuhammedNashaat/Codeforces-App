package com.example.codeforcesapp.codeforces.core.domain

import com.example.codeforcesapp.codeforces.contest.domain.Contest
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.domain.User

interface CodeForcesAPI {
    suspend fun getUser(handles: String): User
    suspend fun getContestList():List<Contest>
    suspend fun getUserStatus(handles: String): List<Submission>
}