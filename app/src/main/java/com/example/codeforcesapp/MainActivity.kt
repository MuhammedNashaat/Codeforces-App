package com.example.codeforcesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
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
import com.example.codeforcesapp.codeforces.core.presentation.BottomAppBar
import com.example.codeforcesapp.codeforces.contest.presentation.contest_list.ContestListScreen
import com.example.codeforcesapp.codeforces.contest.presentation.contest_list.ContestListViewModel
import com.example.codeforcesapp.codeforces.core.presentation.util.errorToString
import com.example.codeforcesapp.codeforces.problems.presentation.problems_list.ProblemListScreen
import com.example.codeforcesapp.codeforces.problems.presentation.problems_list.ProblemListViewModel
import com.example.codeforcesapp.codeforces.user.presentation.user_info.UserInfoViewModel
import com.example.codeforcesapp.codeforces.user.presentation.user_info.UserScreen
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import com.plcoding.cryptotracker.crypto.core.presentation.util.ObserveAsEvent
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeforcesAppTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                ObserveAsEvent(events = ToastController.event) { event ->
                    when (event) {
                        is ToastEvent.ApiFailure -> TODO()
                        is ToastEvent.KtorError -> {
                            Toast.makeText(
                                context,
                                event.event.errorToString(context),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomAppBar(navController = navController) }
                ) { innerPadding ->

                    val viewModel = koinViewModel<UserInfoViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    val contestViewModel = koinViewModel<ContestListViewModel>()
                    val contestState by contestViewModel.state.collectAsStateWithLifecycle()

                    val problemListViewModel = koinViewModel<ProblemListViewModel>()
                    val problemListState by problemListViewModel.state.collectAsStateWithLifecycle()

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
                            if(contestState.contestList != null) {
                                ContestListScreen(
                                    //contestUiList = state.contestList!!, // check '!!'
                                    contestUiList = contestState.contestList!!,
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                            else{
                                Row {  }
                            }
                        }
                        composable("Settings"){
                            if(problemListState.problemList != null) {
                                ProblemListScreen(
                                    state = problemListState,
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                            else{
                                Row{ }
                            }
                        }
                    }
                }
            }
        }
    }
}