package com.example.codeforcesapp.codeforces.core.data.networking

import com.example.codeforcesapp.codeforces.contest.data.mappers.toContest
import com.example.codeforcesapp.codeforces.user.data.mappers.toUser
import com.example.codeforcesapp.codeforces.contest.data.netwoking.dto.ContestDto
import com.example.codeforcesapp.codeforces.contest.data.netwoking.dto.ContestResponseDto
import com.example.codeforcesapp.codeforces.user.data.networking.dto.UserDto
import com.example.codeforcesapp.codeforces.user.data.networking.dto.UserResponseDto
import com.example.codeforcesapp.codeforces.core.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.contest.domain.Contest
import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError
import com.example.codeforcesapp.codeforces.core.domain.util.Result
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

    override suspend fun getUser(handles: String): Result<User, NetworkError> {
        val result : Result<UserResponseDto,NetworkError> = safeCall {
            httpClient.get(urlString = "https://codeforces.com/api/user.info"){
                parameter("handles",handles)
        } };
        return when (result){
            is Result.Error -> Result.Error(error = result.error)
            is Result.Success -> Result.Success(data = result.data.result[0].toUser())
        }
    }
    /////////////////////////////////////////////////////////////////
    override suspend fun getContestList(): Result<List<Contest>, NetworkError> {
        val result: Result<ContestResponseDto,NetworkError> = safeCall {
            httpClient.get(urlString = "https://codeforces.com/api/contest.list")
        }
        return when (result){
            is Result.Error -> Result.Error(error = result.error)
            is Result.Success -> Result.Success(data = result.data.result.map { it.toContest() })
        }
    }
    //////////////////////////////////////////////////////////
    override suspend fun getUserStatus(handles: String): List<Submission> {
        val result: HttpResponse = httpClient.get(
            urlString = "https://codeforces.com/api/user.status?handle=${handles}"
        )
        val responseDto: SubmissionResponseDto = result.body()
        val submissionDtoList: List<SubmissionDto> = responseDto.result
        val submissionList: List<Submission> = submissionDtoList.map{ it.toSubmission() }
        return submissionList
    }
    ////////////////////////////////////////////////////

}
