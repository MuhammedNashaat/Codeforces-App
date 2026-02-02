package com.example.codeforcesapp.codeforces.contest.presentation.contest_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContestListScreen(
    //contestUiList: List<ContestUi>,
    state: ContestListState,
    modifier: Modifier
){
    if(state.isLoading)
    {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            CircularProgressIndicator()
        }
    }
    else {
        Column(
            modifier = modifier
        ) {
            ContestListHeader()
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                items(state.contestList!!) { contestUi ->
                    ContestListItem(
                        contestUi = contestUi,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}