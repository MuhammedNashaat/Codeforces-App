package com.example.codeforcesapp.codeforces.core.domain.util

//this code copied from Philipp Lackner
enum class NetworkError:Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN
}