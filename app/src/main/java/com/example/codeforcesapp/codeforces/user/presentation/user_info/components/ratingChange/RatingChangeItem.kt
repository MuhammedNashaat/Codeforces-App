package com.example.codeforcesapp.codeforces.user.presentation.user_info.components.ratingChange

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.codeforces.core.presentation.colorRating
import com.example.codeforcesapp.codeforces.user.presentation.models.RatingChangeUi
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun RatingChangeItem(
    modifier: Modifier,
    ratingChangeUi:RatingChangeUi
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(top = 5.dp, bottom = 5.dp)
    ){
        Text(
            text = ratingChangeUi.contestName,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        )
        Text(
            text = if(ratingChangeUi.newRating >= ratingChangeUi.oldRating)
                    "+" + (ratingChangeUi.newRating - ratingChangeUi.oldRating ).toString()
                    else    (ratingChangeUi.newRating - ratingChangeUi.oldRating ).toString(),
            color = if(ratingChangeUi.newRating >= ratingChangeUi.oldRating)
                Color.Green    else
                Color.Red,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .width(60.dp)
        )
        Text(
            text = ratingChangeUi.newRating.toString(),
            color = colorRating(ratingChangeUi.newRating),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(end = 5.dp)
                .width(50.dp)
        )
    }
}

@PreviewLightDark
@Composable
fun RatingChangeItemPreview(){
    CodeforcesAppTheme {
        Column {
            RatingChangeHeader()
            Spacer(Modifier.padding(2.dp))
            RatingChangeItem(
                modifier = Modifier,
                ratingChangeUi = RatingChangeUi(
                    contestId = 2,
                    contestName = "Codeforces Beta Round 1",
                    handle = "x",
                    rank = 46,
                    ratingUpdateTimeSeconds = 1267124400,
                    oldRating = 1542,
                    newRating = 1521
                )
            )
            Spacer(Modifier.padding(2.dp))
            RatingChangeItem(
                modifier = Modifier,
                ratingChangeUi = RatingChangeUi(
                    contestId = 2,
                    contestName = "Codeforces Beta Round 2",
                    handle = "x",
                    rank = 46,
                    ratingUpdateTimeSeconds = 1267124400,
                    oldRating = 1502,
                    newRating = 1620
                )
            )
        }

    }
}