package com.farimarwat.movista.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            HomeScreen()
        }
        composable(Screen.Details.route){
            DetailsScreen()
        }
    }
}