package com.example.codeforcesapp.codeforces.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.user.presentation.user_info.UserInfoState
import com.example.codeforcesapp.codeforces.user.presentation.user_info.components.SubmissionChart
import com.example.codeforcesapp.codeforces.user.presentation.user_info.components.UserInfoScreen
import com.example.codeforcesapp.codeforces.user.presentation.user_info.components.ratingChange.RatingChangeScreen

@Composable
fun ProfileScreen(
    state: UserInfoState,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.verticalScroll(rememberScrollState()) //uncomment this line after contestList screen in a different composable
    ) {

        if(state.isLoadingUserInfo){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ){
                CircularProgressIndicator()
            }
        }
        else if(state.userUi != null){
            Column {
                UserInfoScreen(
                    userUi = state.userUi,
                    modifier = Modifier
                )
                SubmissionChart(
                    modifier = Modifier,
                    map = state.userSubmissionRating.toSortedMap()
                )
                RatingChangeScreen(
                    state = state,
                    modifier = Modifier
                )
            }
        }
        else {
            // should be the sign up screen
            Column {

            }
        }
    }
}