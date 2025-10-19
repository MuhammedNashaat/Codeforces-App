package com.example.codeforcesapp.codeforces.presentation.user_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun UserScreen(
    state: UserInfoState,
    onActions: (UserInfoActions) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SearchUser(onActions = onActions)
        if(state.isLoading){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ){
                CircularProgressIndicator()
            }
        }
        else if(state.userUi != null){
            UserInfoScreen(
                userUi = state.userUi,
                modifier = Modifier
            )
        }
    }
}

@PreviewLightDark
@Composable
fun UserScreenPreview()
{
    CodeforcesAppTheme {
        UserScreen(
            state = UserInfoState(
                userUi = userUiPreview,
                isLoading = false,
            ),
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
            onActions = {}
        )
    }
}