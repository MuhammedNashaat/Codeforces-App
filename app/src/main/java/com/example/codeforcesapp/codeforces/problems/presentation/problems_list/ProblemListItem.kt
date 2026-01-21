package com.example.codeforcesapp.codeforces.problems.presentation.problems_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.problems.presentation.models.ProblemUi

@Composable
fun ProblemListItem(
    problemUi: ProblemUi,
    modifier: Modifier
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(top = 5.dp, bottom = 5.dp)
    ){
        Text(
            text = problemUi.contestId.toString() + problemUi.index + "." + problemUi.name,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 10.dp)
                .weight(1f)
        )
        Text(
            text = problemUi.rating.toString(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 10.dp)
        )
    }

}