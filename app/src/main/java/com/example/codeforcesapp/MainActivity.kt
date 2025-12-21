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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codeforcesapp.codeforces.presentation.BottomAppBar
import com.example.codeforcesapp.codeforces.presentation.contest_list.ContestListScreen
import com.example.codeforcesapp.codeforces.presentation.user_info.UserInfoViewModel
import com.example.codeforcesapp.codeforces.presentation.user_info.UserScreen
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeforcesAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomAppBar(navController = navController) }
                ) { innerPadding ->

                    val viewModel = koinViewModel<UserInfoViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    val context = LocalContext.current

                    NavHost(
                        navController = navController,
                        startDestination = "UserScreen"
                    ) {
                        composable("UserScreen"){
                            UserScreen(
                                state = state,
                                onActions = viewModel::onAction,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        composable("ContestListScreen"){
                            if(state.contestList != null) {
                                ContestListScreen(
                                    contestUiList = state.contestList!!, // check '!!'
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}