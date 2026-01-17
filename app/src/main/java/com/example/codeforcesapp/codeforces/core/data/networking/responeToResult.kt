package com.example.codeforcesapp.codeforces.core.data.networking

import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError
import io.ktor.client.statement.HttpResponse
import com.example.codeforcesapp.codeforces.core.domain.util.Result
import io.ktor.client.call.body
import io.ktor.client.call.NoTransformationFoundException

//this code copied from Philipp Lackner
suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, NetworkError> {
    if(response.status.value >= 200 && response.status.value <= 299) {
        try {
            return Result.Success(response.body<T>())
        } catch (e: NoTransformationFoundException){
            return Result.Error(NetworkError.SERIALIZATION)
        }
    }
    else if (response.status.value == 408){
        return Result.Error(NetworkError.REQUEST_TIMEOUT)
    }
    else if (response.status.value == 429){
        return Result.Error(NetworkError.TOO_MANY_REQUESTS)
    }
    else if (response.status.value >= 500 && response.status.value <= 599){
        return Result.Error(NetworkError.SERVER_ERROR)
    }
    else{
        return Result.Error(NetworkError.UNKNOWN)
    }
}