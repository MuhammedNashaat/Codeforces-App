package com.example.codeforcesapp

import com.example.codeforcesapp.codeforces.core.domain.util.NetworkError
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

sealed interface ToastEvent{
    data class KtorError(val event: NetworkError) : ToastEvent
    data class ApiFailure(val comment: String) : ToastEvent
}

object ToastController {
    private val _event = Channel<ToastEvent>()
    val event = _event.receiveAsFlow()

    suspend fun sendEvent(event: ToastEvent){
        _event.send(event)
    }
}