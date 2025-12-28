package com.example.codeforcesapp.codeforces.core.data.networking

import com.example.codeforcesapp.codeforces.contest.data.mappers.toContest
import com.example.codeforcesapp.codeforces.user.data.mappers.toUser
import com.example.codeforcesapp.codeforces.contest.data.netwoking.dto.ContestDto
import com.example.codeforcesapp.codeforces.contest.data.netwoking.dto.ContestResponseDto
import com.example.codeforcesapp.codeforces.user.data.networking.dto.UserDto
import com.example.codeforcesapp.codeforces.user.data.networking.dto.UserResponseDto
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.contest.domain.Contest
import com.example.codeforcesapp.codeforces.user.data.mappers.toSubmission
import com.example.codeforcesapp.codeforces.user.data.networking.dto.SubmissionDto
import com.example.codeforcesapp.codeforces.user.data.networking.dto.SubmissionResponseDto
import com.example.codeforcesapp.codeforces.user.domain.Submission
import com.example.codeforcesapp.codeforces.user.domain.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class CodeForcesAPIImpl(
    private val httpClient: HttpClient
): CodeForcesAPI {
    override suspend fun getUser(
        handles:String
    ): User {
        val result: HttpResponse = httpClient.get(
            urlString = "https://codeforces.com/api/user.info"
        ){
            parameter("handles",handles)
        }
        val userResponseDto: UserResponseDto = result.body()
        val userDto: UserDto = userResponseDto.result[0]
        val user: User = userDto.toUser()
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

    //////////////////////////////////////////////////////////
    override suspend fun getUserStatus(handle: String): List<Submission> {
        val result: HttpResponse = httpClient.get(
            urlString = "https://codeforces.com/api/user.status?handle=${handle}"
        )
        val responseDto: SubmissionResponseDto = result.body()
        val submissionDtoList: List<SubmissionDto> = responseDto.result
        val submissionList: List<Submission> = submissionDtoList.map{ it.toSubmission() }
        return submissionList
    }
}
