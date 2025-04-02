package com.farimarwat.movista.android.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.farimarwat.movista.data.model.Genre

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Chips(genres: List<Genre>) {
    FlowRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        genres.forEach { genre ->
            AssistChip(
                onClick = {},
                label = { Text(genre.name) }
            )
        }
    }
}
