package com.example.codeforcesapp.codeforces.user.domain

data class Problem(
    val contestId: Int? = null,
    val problemsetName: String = "",
    val index: String,
    val name: String,
    val type: String,
    val points: Float = 0f,
    val rating: Int? = null,
    val tags: List<String>
)
/*
enum class TypeOfProblem{
    PROGRAMMING,QUESTION
}
*/