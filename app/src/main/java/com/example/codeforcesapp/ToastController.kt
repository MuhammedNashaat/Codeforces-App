package com.example.codeforcesapp

import com.example.codeforcesapp.codeforces.core.domain.util.Error
import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object ToastController {
    private val _event = Channel<NetworkError>()
    val event = _event.receiveAsFlow()

    suspend fun sendEvent(event: NetworkError){
        _event.send(event)
    }
}