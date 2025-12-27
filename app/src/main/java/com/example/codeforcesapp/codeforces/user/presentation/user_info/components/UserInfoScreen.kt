package com.example.codeforcesapp.codeforces.user.presentation.user_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.sp
import com.example.codeforcesapp.codeforces.core.presentation.TextRank
import com.example.codeforcesapp.codeforces.core.presentation.colorRating
import com.example.codeforcesapp.codeforces.user.presentation.models.UserUi
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun UserInfoScreen(
    userUi: UserUi,
    modifier: Modifier
)
{
    Column(
        modifier = modifier.fillMaxWidth(1f)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = MaterialTheme.colorScheme.surfaceVariant),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = userUi.rank,
            color = colorRating(userUi.rating),
            fontSize = 20.sp
        )
        TextRank(
            text = userUi.handle,
            rating = userUi.rating,
            fontSize = 25.sp
        )
        ProfilePhoto(
            url = userUi.titlePhoto,
            rating = userUi.rating
        )
        Row {
            Text(
                text = userUi.country + ",",
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = userUi.city,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row {
            Text(
                text = "Contest rating: ",
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = userUi.rating.toString(),
                color = colorRating(userUi.rating)
            )
        }
        Row {
            Text(
                text = "Max rating: ",
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = userUi.maxRank + ", " + userUi.maxRating.toString(),
                color = colorRating(userUi.maxRating)
            )
        }
        Text(
            text = "Contribution: " + userUi.contribution,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "Friend of: ${userUi.friendOfCount} users",
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = userUi.email,
            color = MaterialTheme.colorScheme.onSurface
        )

    }
}

internal val userUiPreview: UserUi = UserUi(
    handle = "MuhammedNashaat",
    email = "muhammednashaat@gmail.com",
    vkId = "fa",
    openId = "fa",
    firstName = "Muhammed",
    lastName = "Nashat",
    country = "Egypt",
    city = "Sohag",
    organization = "Assiut University",
    contribution = 0,
    rank = "newbie",
    rating = 992,
    maxRank = "pupil",
    maxRating = 1379,
    lastOnlineTimeSeconds = 1757734467,
    registrationTimeSeconds = 1572956261,
    friendOfCount = 6,
    avatar = "https://userpic.codeforces.org/1307811/avatar/dd246a8f00f6dd20.jpg",
    titlePhoto = "https://userpic.codeforces.org/1307811/title/76457b262e216598.jpg"
)

@PreviewLightDark
@Composable
fun UserInfoPreview(){
    CodeforcesAppTheme {
        UserInfoScreen(
            userUi = userUiPreview,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surface)
        )
    }
}