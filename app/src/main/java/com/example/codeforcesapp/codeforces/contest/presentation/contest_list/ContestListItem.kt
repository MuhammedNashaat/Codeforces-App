package com.example.codeforcesapp.codeforces.contest.presentation.contest_list

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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.contest.presentation.models.ContestUi
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun ContestListItem(
    contestUi: ContestUi,
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
            text = contestUi.name,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(start = 10.dp)
                .weight(3f)
        )
        Text(
            text = contestUi.durationSeconds.toString(),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = contestUi.phase,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(end = 10.dp)
                .weight(1f)
        )
    }

}

@PreviewLightDark
@Composable
fun ContestListItemPreview()
{
    CodeforcesAppTheme {
        ContestListItem(
            contestUi = contestUiPreview,
            modifier = Modifier
        )
    }
}

val contestUiPreview: ContestUi = ContestUi(
    id = 2165,
    name = "Codeforces Round (Div. 1)",
    type = "CF",
    phase = "BEFORE",
    frozen = false,
    durationSeconds = 7200,
    startTimeSeconds = 1763303700,
    relativeTimeSeconds = -1721032,
)