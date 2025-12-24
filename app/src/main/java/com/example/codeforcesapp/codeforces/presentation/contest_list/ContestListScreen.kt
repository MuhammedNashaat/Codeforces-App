package com.example.codeforcesapp.codeforces.presentation.contest_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.presentation.models.ContestUi

@Composable
fun ContestListScreen(
    contestUiList: List<ContestUi>,
    modifier: Modifier
){
    Column(
        modifier = modifier
    ) {
        ContestListHeader()
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            items(contestUiList){ contestUi ->
                ContestListItem(
                    contestUi = contestUi,
                    modifier = Modifier
                )
            }
        }
    }
}