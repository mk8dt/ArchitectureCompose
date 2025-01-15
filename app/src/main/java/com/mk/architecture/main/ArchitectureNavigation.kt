package com.mk.architecture.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mk.architecture.detail.Detail
import com.mk.architecture.home.Home
import com.mk.architecture.home.presentation.HomeScreen

const val BASE_DEEPLINK = "architecture://destination-"

@Composable
fun ArchitectureNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Home.route
    ) {

        composable(route = Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Detail.route,
            arguments = Detail.arguments,
            deepLinks = Detail.deepLink
        ) {

        }
    }
}

open class NavRoute(val route: String) {
    open val arguments: List<NamedNavArgument> = emptyList()
    open val deepLink: List<NavDeepLink> = emptyList()
}