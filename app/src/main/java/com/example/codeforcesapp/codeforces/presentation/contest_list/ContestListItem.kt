package com.example.codeforcesapp.codeforces.presentation.contest_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.presentation.models.ContestUi
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun ContestListItem(
    contestUi:ContestUi,
    modifier: Modifier
){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ){
        Text(
            text = contestUi.name
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