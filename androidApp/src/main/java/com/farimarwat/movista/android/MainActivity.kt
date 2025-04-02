package com.farimarwat.movista.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.farimarwat.movista.android.presentation.navigation.AppNavHost
import com.farimarwat.movista.android.presentation.navigation.Screen
import com.farimarwat.movista.android.presentation.screen.MovieSearchScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val  navHostController = rememberNavController()
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(
                        navHostController = navHostController
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(navHostController:NavHostController){
    var showSearchScreen by remember { mutableStateOf(false) }
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text("Movista")},
                actions = {
                    IconButton(onClick = {
                        showSearchScreen = !showSearchScreen
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ){ paddingValues ->
        AppNavHost(
            modifier = Modifier
                .padding(paddingValues)

                ,
            navController = navHostController
        )
        MovieSearchScreen(
            show = showSearchScreen,
            onDismiss = {showSearchScreen = !showSearchScreen},
            onMovieClicked = {
                navHostController.navigate("${Screen.Details.route}/${it.id}")
                showSearchScreen = false
            }
        )
    }
}

