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
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.farimarwat.movista.domain.model.Movie
import com.farimarwat.movista.domain.model.Series

@Composable
fun SeriesItem(series: Series){
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
                model = series.getFullPosterPath(500),
                contentDescription = series.name,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.BottomCenter),
                text = series.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}