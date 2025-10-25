package com.example.codeforcesapp.codeforces.data

import com.example.codeforcesapp.codeforces.data.mappers.toContest
import com.example.codeforcesapp.codeforces.data.mappers.toUser
import com.example.codeforcesapp.codeforces.data.networking.dto.ContestDto
import com.example.codeforcesapp.codeforces.data.networking.dto.ContestResponseDto
import com.example.codeforcesapp.codeforces.data.networking.dto.UserDto
import com.example.codeforcesapp.codeforces.data.networking.dto.UserResponseDto
import com.example.codeforcesapp.codeforces.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.domain.Contest
import com.example.codeforcesapp.codeforces.domain.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class CodeForcesAPIImpl(
    private val httpClient: HttpClient
):CodeForcesAPI{
    override suspend fun getUser(
        handles:String
    ): User {
        val result: HttpResponse = httpClient.get(
            urlString = "https://codeforces.com/api/user.info"
        ){
            parameter("handles",handles)
        }
        val userResponseDto:UserResponseDto = result.body()
        val userDto:UserDto = userResponseDto.result[0]
        val user:User = userDto.toUser()
        return user
    }

    /////////////////////////////////////////////////////////////////
    override suspend fun getContestList(): List<Contest> {
        val result: HttpResponse = httpClient.get(
            urlString = "https://codeforces.com/api/contest.list"
        )
        val responseDto: ContestResponseDto = result.body()
        val contestDtoList : List<ContestDto> = responseDto.result
        val contestList: List<Contest> = contestDtoList.map { it.toContest() }
        return contestList
    }
}
