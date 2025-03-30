package com.farimarwat.movista.data.model

import com.farimarwat.movista.domain.model.Series
import kotlinx.serialization.Serializable

@Serializable
data class SeriesResultDto(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
) {
    fun toSeries():Series{
        return Series(
            adult = this.adult,
            backdropPath = this.backdrop_path,
            firstAirDate = this.first_air_date,
            genreIds = this.genre_ids,
            id = this.id,
            name = this.name,
            originCountry = this.origin_country,
            originalLanguage = this.original_language,
            originalName = this.original_name,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = this.poster_path,
            voteAverage = this.vote_average,
            voteCount = this.vote_count
        )
    }
}