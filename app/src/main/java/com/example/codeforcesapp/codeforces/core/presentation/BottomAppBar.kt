package com.example.codeforcesapp.codeforces.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)

val items = listOf(
    BottomNavigationItem(
        title = "Search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        route = "UserScreen"
    ),
    BottomNavigationItem(
        title = "Contests",
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Outlined.DateRange,
        route = "ContestListScreen" //this is for testing
    ),
    BottomNavigationItem(
        title = "Problems",
        selectedIcon = Icons.Filled.Check,
        unselectedIcon = Icons.Outlined.Check,
        route = "Problems"
    ),
)

@Composable
fun BottomAppBar(
    navController: NavController
){
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    /*
                    the navigation controller is here
                    */
                    navController.navigate(bottomNavigationItem.route)
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) bottomNavigationItem.selectedIcon
                            else bottomNavigationItem.unselectedIcon,
                        contentDescription = bottomNavigationItem.title
                    )
                },
                label = {
                    Text(text = bottomNavigationItem.title)
                },
                alwaysShowLabel = true,
            )
        }
    }
}

@PreviewLightDark
@Composable
fun BottomAppBarPreview()
{
    MaterialTheme{
        BottomAppBar(
            navController = TODO()
        )
    }
}