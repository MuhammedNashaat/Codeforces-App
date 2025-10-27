package com.example.codeforcesapp.codeforces.presentation.user_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.codeforcesapp.R
import com.example.codeforcesapp.codeforces.presentation.colorRating
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun ProfilePhoto(
    url: String,
    rating: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment =  Alignment.BottomEnd,
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            modifier = Modifier.height(100.dp).width(100.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Box(
            modifier = Modifier.clip(RoundedCornerShape(20.dp))
                .background(color = colorRating(rating)),
        ){
            Text(
                text = rating.toString(),
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}

@PreviewLightDark
@Composable
fun ProfilePhotoPreview(){
    CodeforcesAppTheme {
        ProfilePhoto(
            url = userUiPreview.titlePhoto,
            rating = userUiPreview.rating
        )
    }
}