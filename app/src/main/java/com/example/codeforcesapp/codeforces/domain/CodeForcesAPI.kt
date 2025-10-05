package com.example.codeforcesapp.codeforces.domain

interface CodeForcesAPI {
    suspend fun getUser(handles: String):User
}