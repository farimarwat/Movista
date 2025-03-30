package com.farimarwat.movista.android.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun MovieItem(){
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
    MovieItem(movie)
}
@Composable
fun MovieItem(movie:Movie){
    Card (
        modifier = Modifier
            .padding(bottom = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(200.dp)
        ){
            AsyncImage(
                model = movie.getFullPosterPath(500),
                contentDescription = movie.title,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.BottomCenter),
                text = movie.title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}