package com.example.codeforcesapp.codeforces.data

import com.example.codeforcesapp.codeforces.data.networking.dto.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class APICalls(
    private val httpClient: HttpClient
){
    suspend fun getUserTest(
        userName:String
    ):UserDto{
        val result: HttpResponse = httpClient.get(
            urlString = "https://codeforces.com/api/user.info"
        ){
            parameter("handles",userName)
        }
        val s:UserDto = result.body()
        return s
    }
}
