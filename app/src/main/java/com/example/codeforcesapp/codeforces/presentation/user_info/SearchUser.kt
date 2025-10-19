package com.example.codeforcesapp.codeforces.presentation.user_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.codeforcesapp.Http
import com.example.codeforcesapp.codeforces.data.CodeForcesAPIImpl
import com.example.codeforcesapp.ui.theme.CodeforcesAppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun SearchUser(
    onActions: (UserInfoActions) -> Unit
){
    var search by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = search,
            onValueChange = { search = it },
            placeholder = { Text(text = "Enter User's Name")},
            leadingIcon = { Icon(imageVector =  Icons.Default.Search, contentDescription = "search icon")},
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Button(
            onClick = {
                onActions(
                    UserInfoActions.OnSearchUserClick(handle = search.text)
                )
                //just for testing
                /*GlobalScope.launch {
                    CodeForcesAPIImpl(Http).getUser(search.text)
                }
                */
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search button")
        }
    }
}

@PreviewLightDark
@Composable
fun SearchUserPreview()
{
    CodeforcesAppTheme {
        SearchUser(
            onActions = {}
        )
    }
}