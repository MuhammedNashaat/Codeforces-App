package com.example.codeforcesapp.codeforces.user.presentation.user_info.components.ratingChange

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.user.presentation.user_info.UserInfoState

@Composable
fun RatingChangeScreen(
    state: UserInfoState,
    modifier: Modifier
) {
    if(state.isLoadingRatingChange)
    {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ){
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
        ) {
            RatingChangeHeader()
            Spacer(modifier = Modifier.height(10.dp))
            for (item in state.ratingChangeUi){
                RatingChangeItem(
                    modifier = Modifier,
                    ratingChangeUi = item
                )
                Spacer(modifier.height(5.dp))
            }
        }
    }
}