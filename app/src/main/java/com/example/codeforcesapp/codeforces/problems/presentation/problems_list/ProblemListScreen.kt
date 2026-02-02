package com.example.codeforcesapp.codeforces.problems.presentation.problems_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProblemListScreen(
    state: ProblemListState,
    modifier: Modifier = Modifier
){
    if(state.isLoading || state.problemList == null) {
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(state.problemList!!) { problemUi ->
                    ProblemListItem(
                        problemUi = problemUi,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}