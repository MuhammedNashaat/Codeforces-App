package com.example.codeforcesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.codeforcesapp.codeforces.presentation.user_info.UserInfoViewModel
import com.example.codeforcesapp.codeforces.presentation.user_info.components.UserScreen
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import org.koin.androidx.compose.koinViewModel

//for testing until implement koin di
//val Http:HttpClient = HttpClientFactory.create(CIO.create())

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeforcesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*UserInfoScreen(
                        userUi = userUiPreview,
                        modifier = Modifier.padding(innerPadding)
                    )*/

                    val viewModel = koinViewModel<UserInfoViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    val context = LocalContext.current

                    UserScreen(
                        state = state,
                        onActions = viewModel::onAction,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}