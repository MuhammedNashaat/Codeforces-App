package com.example.codeforcesapp.codeforces.presentation.contest_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.presentation.models.ContestUi

@Composable
fun ContestListScreen(
    contestUiList: List<ContestUi>,
    modifier: Modifier
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(contestUiList){ contestUi ->
            ContestListItem(
                contestUi = contestUi,
                modifier = modifier
            )
        }
    }
}