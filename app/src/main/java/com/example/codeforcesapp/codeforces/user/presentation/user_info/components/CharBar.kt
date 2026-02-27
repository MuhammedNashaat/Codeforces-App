package com.example.codeforcesapp.codeforces.user.presentation.user_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun CharBar(
    modifier: Modifier,
    key: Int,
    value: Int,
    color: Color,
    percentage: Float
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        val conf = LocalConfiguration.current
        val maxWidth = conf.screenWidthDp.dp - 60.dp - 35.dp - 20.dp
        // 60 -> is box width(50) and the padding (10)
        // 20 -> for SubmissionChar padding
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 5.dp,end = 5.dp)
                .height(35.dp)
                .width(50.dp)
                .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp))
                //.clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.secondary)
        ){
            Text(
                text = key.toString(),
                color = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.padding(5.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .height(35.dp)
                .width(maxWidth * percentage)
                .clip(RoundedCornerShape(topEnd = 10.dp , bottomEnd = 10.dp))
                //.clip(RoundedCornerShape(10.dp))
                .background(color)
        )
        Box(
            modifier = Modifier
                .padding(5.dp)
                .size(25.dp)
        ) {
            Text(
                text = value.toString(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 10.sp,

            )
        }
    }
}

@PreviewLightDark
@Composable
fun CharBarPreview(){
     CodeforcesAppTheme(){
         Column(
             Modifier.background(MaterialTheme.colorScheme.surface)
         ){
             CharBar(
                 modifier = Modifier,
                 key = 900,
                 value = 1230,
                 color = Color.Green,
                 percentage = 1f
             )
             Spacer(modifier = Modifier.size(5.dp))
             CharBar(
                 modifier = Modifier,
                 key = 1500,
                 value = 1230,
                 color = Color.Blue,
                 percentage = 0.5f
             )
         }
    }
}