package com.example.codeforcesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.codeforcesapp.codeforces.core.data.networking.HttpClientFactory
import com.example.codeforcesapp.codeforces.data.mappers.toUser
import com.example.codeforcesapp.codeforces.data.networking.dto.UserResponseDto
import com.example.codeforcesapp.codeforces.presentation.UserInfo
import com.example.codeforcesapp.codeforces.presentation.userUiPreview
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//for testing until implement koin di
val Http:HttpClient = HttpClientFactory.create(CIO.create())

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeforcesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserInfo(
                        userUi = userUiPreview,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}