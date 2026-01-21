package com.example.codeforcesapp.codeforces.problems.presentation.problems_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProblemListScreen(
    state: ProblemListState,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(state.problemList!!){ problemUi ->
                ProblemListItem(
                    problemUi = problemUi,
                    modifier = Modifier
                )
            }
        }
    }
}