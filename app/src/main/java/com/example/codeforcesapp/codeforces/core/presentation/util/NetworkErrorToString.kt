package com.example.codeforcesapp.codeforces.core.presentation.util

import android.content.Context
import com.example.codeforcesapp.R
import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError

//fun NetworkError.toString(context: Context): String
fun NetworkError.errorToString(context: Context): String
{
    val resID = when(this){
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUESTS -> R.string.error_too_many_requests
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_unknown
        NetworkError.SERIALIZATION -> R.string.error_unknown
        NetworkError.UNKNOWN -> R.string.error_unknown
    }
    return context.getString(resID)
}