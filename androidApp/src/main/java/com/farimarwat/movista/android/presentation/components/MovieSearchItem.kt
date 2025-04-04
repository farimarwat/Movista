package com.farimarwat.movista.android.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.farimarwat.movista.domain.model.Movie

@Composable
@Preview
fun MovieSearchItem_Previes(){
    val movie = Movie(
        adult = false,
        backdropPath = "/m2mzlsJjE3UAqeUB5fLUkpWg4Iq.jpg",
        genreIds = listOf(53, 878), // Thriller, Sci-Fi
        id = 1165067,
        originalLanguage = "en",
        originalTitle = "Cosmic Chaos",
        overview = "Battles in virtual reality, survival in a post-apocalyptic wasteland, a Soviet spaceship giving a distress signal - Fantastic stories created with advanced special effects and passion.",
        popularity = 573.0464,
        posterPath = "/mClzWv7gBqgXfjZXp49Enyoex1v.jpg",
        releaseDate = "2023-08-03",
        title = "Cosmic Chaos",
        video = false,
        voteAverage = 5.2,
        voteCount = 10
    )
    MovieSearchItem(movie)
}
@Composable
fun MovieSearchItem(
    movie: Movie,
    onClicked:(Movie)->Unit={}
    ){
    Card (
        onClick = {onClicked(movie)},
        modifier = Modifier
            .padding(bottom = 2.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp),
                model = movie.getFullbackDropPath(500),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
            )
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ){
                Text(
                    modifier = Modifier,
                    text = movie.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = movie.title,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = movie.voteAverage.toString(),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Text(
                    text = "Language: ${movie.originalLanguage}"
                )
                Text(
                    text = "Released on: ${movie.releaseDate}"
                )
            }
        }
    }
}