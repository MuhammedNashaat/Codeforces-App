package com.example.codeforcesapp.codeforces.data

import com.example.codeforcesapp.codeforces.data.mappers.toUser
import com.example.codeforcesapp.codeforces.data.networking.dto.UserDto
import com.example.codeforcesapp.codeforces.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.domain.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class APICalls(
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
        val r:UserDto = result.body()
        println(r)
        val user:User = r.toUser()
        println("here is the output")
        println(user)
        return user
    }
}
