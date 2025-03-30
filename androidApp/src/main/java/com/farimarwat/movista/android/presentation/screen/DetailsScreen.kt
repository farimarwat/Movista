package com.farimarwat.movista.android.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.farimarwat.movista.android.presentation.viewmodel.DetailsScreenViewModel
import com.farimarwat.movista.domain.model.Movie
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
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                model = movie.getFullPosterPath(500),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}