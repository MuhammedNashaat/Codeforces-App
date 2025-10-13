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
import com.example.codeforcesapp.codeforces.presentation.user_info.UserInfoScreen
import com.example.codeforcesapp.codeforces.presentation.user_info.userUiPreview
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

//for testing until implement koin di
val Http:HttpClient = HttpClientFactory.create(CIO.create())

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeforcesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserInfoScreen(
                        userUi = userUiPreview,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}