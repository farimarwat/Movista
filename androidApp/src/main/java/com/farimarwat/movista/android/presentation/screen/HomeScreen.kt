package com.farimarwat.movista.android.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.farimarwat.movista.android.presentation.components.PopularMovieItem
import com.farimarwat.movista.android.presentation.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier,viewModel: HomeScreenViewModel = koinViewModel()){
    val popularMovies by viewModel.popularMovies.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies()
    }
    Box(
        modifier = Modifier
            .then(modifier)
    ){
        val pagerState = rememberPagerState (pageCount = {popularMovies.size})
        HorizontalPager(
            state = pagerState
        ) { index ->
            val movie = popularMovies.get(index)
            PopularMovieItem(movie)
        }
    }
}