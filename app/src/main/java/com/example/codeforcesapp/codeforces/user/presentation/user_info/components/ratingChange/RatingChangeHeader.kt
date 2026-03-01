package com.example.codeforcesapp.codeforces.user.presentation.user_info.components.ratingChange

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun RatingChangeHeader(){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(top = 5.dp, bottom = 5.dp)
    ) {
        Text(
            text = "Contest",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        )
        Text(
            text = "Rating\nChange",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .width(60.dp)
        )
        Text(
            text = "New\nRating",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(end = 5.dp)
                .width(50.dp)
        )
    }
}

@PreviewLightDark
@Composable
fun RatingChangeHeaderPreview(){
    CodeforcesAppTheme {
        RatingChangeHeader()
    }
}