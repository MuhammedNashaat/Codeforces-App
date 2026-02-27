package com.example.codeforcesapp.codeforces.user.presentation.user_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codeforcesapp.codeforces.core.presentation.colorRating
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun SubmissionChart(
    modifier: Modifier,
    map: MutableMap<Int,Int>,
){
    Column(
        modifier = modifier.fillMaxWidth(1f)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = MaterialTheme.colorScheme.surfaceVariant),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "Problem Ratings",
            fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
            modifier = Modifier.padding(20.dp)
        )
        for (rank in map) {
            CharBar(
                modifier = Modifier,
                key = rank.key,
                value = rank.value,
                color = colorRating(rank.key),
                percentage = (rank.value.toFloat()/map.values.max().toFloat())
            )
            Spacer(
                modifier = Modifier.size(5.dp)
            )
        }
    }
}