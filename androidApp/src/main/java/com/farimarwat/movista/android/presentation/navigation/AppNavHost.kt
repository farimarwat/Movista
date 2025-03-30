package com.farimarwat.movista.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.farimarwat.movista.android.presentation.screen.DetailsScreen
import com.farimarwat.movista.android.presentation.screen.HomeScreen

@Composable
fun AppNavHost(
    modifier:Modifier = Modifier,
    navController:NavHostController,
    startDestination:String = Screen.Home.route
){
    NavHost(
        navController = navController,
        startDestination = startDestination){
        composable(Screen.Home.route){
            HomeScreen(
                modifier = modifier,
                onMovieClicked = {
                    navController.navigate("${Screen.Details.route}/${it.id}")
                }
            )
        }
        composable(
            route = "${Screen.Details.route}/{id}",
            arguments = listOf(
                navArgument("id"){type = NavType.StringType}
            )
        ){ backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: "0"
            DetailsScreen(
                modifier = modifier,
                id = id
            )
        }
    }
}