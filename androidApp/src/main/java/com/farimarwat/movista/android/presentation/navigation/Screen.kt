package com.farimarwat.movista.android.presentation.navigation

sealed class Screen(val route:String) {
    object Home:Screen("Home")
    object Details:Screen("Details")
}