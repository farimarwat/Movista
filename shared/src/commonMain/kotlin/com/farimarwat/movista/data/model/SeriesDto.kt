package com.farimarwat.movista.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SeriesDto(
    val page: Int,
    val results: List<SeriesResultDto>,
    val total_pages: Int,
    val total_results: Int
)