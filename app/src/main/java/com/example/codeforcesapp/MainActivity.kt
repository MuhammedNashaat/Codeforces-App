package com.example.codeforcesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.codeforcesapp.codeforces.core.data.networking.HttpClientFactory
import com.example.codeforcesapp.codeforces.data.APICalls
import com.example.codeforcesapp.codeforces.data.mappers.toUser
import com.example.codeforcesapp.codeforces.data.networking.dto.UserDto
import com.example.codeforcesapp.codeforces.data.networking.dto.UserResponseDto
import com.example.codeforcesapp.codeforces.domain.CodeForcesAPI
import com.example.codeforcesapp.codeforces.domain.User
import com.example.codeforcesapp.codeforces.presentation.UserInfo
import com.example.codeforcesapp.codeforces.presentation.userUiPreview
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.request
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val Http:HttpClient = HttpClientFactory.create(CIO.create())
        GlobalScope.launch {
            val response = Http.get(
                urlString = "https://codeforces.com/api/user.info?handles=DmitriyH"
            )
            print(response)
            println("-------")
            println(response.body<UserResponseDto>().result.map { it.toUser() })
            //val endResult:List<User>
            //val res = response.body<UserResponseDto>()
        }
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