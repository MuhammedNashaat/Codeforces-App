package com.example.codeforcesapp.codeforces.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.example.codeforcesapp.codeforces.presentation.models.UserUi
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme

@Composable
fun UserInfo(
    userUi: UserUi,
    modifier: Modifier
)
{
    Row (
        modifier = modifier
    ){
        Column {
            Text(
                text = userUi.rank,
                color = colorRating(userUi.rating),
                fontSize = 20.sp
            )
            TextRank(
                text = userUi.handle,
                rating = userUi.rating,
                fontSize = 30.sp
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
        Box {
            //here is the photo
        }
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
        UserInfo(
            userUi = userUiPreview,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surface)
        )
    }
}