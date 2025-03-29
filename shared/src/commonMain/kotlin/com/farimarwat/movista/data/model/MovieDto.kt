package com.farimarwat.movista.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val page: Int,
    val results: List<ResultDto>,
    val total_pages: Int,
    val total_results: Int
)