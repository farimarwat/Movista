package com.farimarwat.movista.android.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.farimarwat.movista.android.presentation.components.Chips
import com.farimarwat.movista.android.presentation.viewmodel.DetailsScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    modifier:Modifier = Modifier,
    id:String,
    viewModel: DetailsScreenViewModel = koinViewModel()){
    val movieDetails by viewModel.movieDetails.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.fetchMovieDetails(id)
    }
    movieDetails?.let{movie ->
        Column (
            modifier = Modifier
                .then(modifier)
                .fillMaxSize()
        ){
           Card (
               elevation = CardDefaults.cardElevation(8.dp)
           ){
               Column(
               ) {
                   AsyncImage(
                       modifier = Modifier
                           .fillMaxWidth()
                           .height(400.dp),
                       model = movie.getFullPosterPath(500),
                       contentDescription = movie.title,
                       contentScale = ContentScale.Crop
                   )
                   Column (
                       modifier = Modifier
                           .padding(8.dp)
                   ){
                       Text(
                           text = movie.title,
                           style = MaterialTheme.typography.titleMedium
                       )
                       Text(
                           text = movie.overview,
                           style = MaterialTheme.typography.bodyMedium
                       )
                       Chips(movie.genres)
                   }
               }
           }
        }
    }
}