package com.farimarwat.movista.android.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.farimarwat.movista.android.presentation.components.MovieSearchItem
import com.farimarwat.movista.android.presentation.viewmodel.HomeScreenViewModel
import com.farimarwat.movista.domain.model.Movie
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchScreen(
    show:Boolean = false,
    viewModel: HomeScreenViewModel = koinViewModel(),
    onDismiss:()->Unit={},
){
    var query by remember { mutableStateOf("") }
    var sheetState = rememberModalBottomSheetState()
    val list by viewModel.searchMovies.collectAsStateWithLifecycle()
    if(show){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {onDismiss()}
        ) {
            Column (
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
            ){
                OutlinedTextField(
                    value = query,
                    onValueChange = {
                        query = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    label = {
                        Text(
                            "Search movies...",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    trailingIcon = {
                        if (query.isNotEmpty()) {
                            IconButton(
                                onClick = { query = "" }
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Clear",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = MaterialTheme.shapes.extraLarge, // Rounded corners

                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search, // Shows "Search" button on keyboard
                        capitalization = KeyboardCapitalization.Sentences
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                           viewModel.fetchSearchMovies(query)
                        }
                    )
                )

                LazyColumn{
                    items(list){item ->
                        MovieSearchItem(movie = item)
                    }
                }

            }
        }
    }
}