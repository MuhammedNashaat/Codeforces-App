package com.example.codeforcesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.codeforcesapp.codeforces.core.data.networking.HttpClientFactory
import com.example.codeforcesapp.codeforces.presentation.UserInfo
import com.example.codeforcesapp.codeforces.presentation.userUiPreview
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import io.ktor.client.engine.cio.CIO

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        HttpClientFactory.create(CIO.create())
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeforcesAppTheme {
        Greeting("Android")
    }
}