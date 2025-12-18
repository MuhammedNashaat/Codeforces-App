package com.example.codeforcesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

interface Destinations {
    val route: String
}

object UserScreen:Destinations{
    override val route: String =  "UserScreen"
}

object ContestList:Destinations{
    override val route: String =  "ContestList"
}
