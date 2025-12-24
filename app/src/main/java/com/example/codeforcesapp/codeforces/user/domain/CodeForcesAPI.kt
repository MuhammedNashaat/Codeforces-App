package com.example.codeforcesapp.codeforces.user.domain

import com.example.codeforcesapp.codeforces.contest.domain.Contest

interface CodeForcesAPI {
    suspend fun getUser(handles: String): User
    suspend fun getContestList():List<Contest>
}