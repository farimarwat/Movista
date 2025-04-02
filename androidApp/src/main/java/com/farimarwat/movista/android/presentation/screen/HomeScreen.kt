package com.farimarwat.movista.android.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.farimarwat.movista.android.presentation.components.MovieItem
import com.farimarwat.movista.android.presentation.components.PopularMovieItem
import com.farimarwat.movista.android.presentation.components.SeriesItem
import com.farimarwat.movista.android.presentation.viewmodel.HomeScreenViewModel
import com.farimarwat.movista.domain.model.Movie
import com.farimarwat.movista.domain.model.Series
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: HomeScreenViewModel = koinViewModel(),
    onMovieClicked:(Movie)->Unit={},
    onSeriesClicked:(Series)->Unit={}
    ){
    val popularMovies by viewModel.popularMovies.collectAsStateWithLifecycle()
    val trendingMovies by viewModel.trendingMovies.collectAsStateWithLifecycle()
    val topRatedSeries by viewModel.topRatedSeries.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies()
        viewModel.fetchTrendingMovies()
        viewModel.fetchTopRatedSeries()
    }
    Box(
        modifier = Modifier
            .then(modifier)
    ){
        Column {

            //Popular Movies
            val pagerState = rememberPagerState (pageCount = {popularMovies.size})
            HorizontalPager(
                state = pagerState
            ) { index ->
                val movie = popularMovies.get(index)
                PopularMovieItem(movie){
                    onMovieClicked(movie)
                }
            }

            //Trending Movies
           if(trendingMovies.size > 0){
               Column {
                   Text(
                       text = "Trending Movies",
                       style = MaterialTheme.typography.titleMedium
                   )
                   LazyRow (
                       horizontalArrangement = Arrangement.spacedBy(8.dp)
                   ){
                       items(trendingMovies){movie ->
                           MovieItem(movie){
                               onMovieClicked(it)
                           }
                       }
                   }
               }
           }
            //Top Rated Series
            if(topRatedSeries.size > 0){
                Column {
                    Text(
                        text = "Top Rated Series",
                        style = MaterialTheme.typography.titleMedium
                    )
                    LazyRow (
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        items(topRatedSeries){series ->
                            SeriesItem(series)
                        }
                    }
                }
            }
        }
    }
}