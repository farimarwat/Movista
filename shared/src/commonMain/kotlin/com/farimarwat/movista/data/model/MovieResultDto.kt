package com.farimarwat.movista.data.model

import com.farimarwat.movista.domain.model.Movie
import kotlinx.serialization.Serializable

@Serializable
data class MovieResultDto(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
){
    fun toMovie():Movie{
        return Movie(
            adult = this.adult,
            backdropPath = this.backdrop_path,
            genreIds = this.genre_ids,
            id = this.id.toLong(),
            originalLanguage = this.original_language,
            originalTitle =  this.original_title,
            overview = this.overview,
            popularity = this.popularity,
            posterPath = this.poster_path,
            releaseDate = this.release_date,
            title = title,
            video = video,
            voteAverage = vote_average,
            voteCount = vote_count.toLong()
        )
    }
}