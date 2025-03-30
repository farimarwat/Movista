package com.farimarwat.movista.domain.model

data class Movie(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
){
    fun getFullPosterPath(imageWidth:Int):String{
        return "https://image.tmdb.org/t/p/w$imageWidth${this.posterPath}"
    }
    fun getFullbackDropPath(imageWidth:Int):String{
        return "https://image.tmdb.org/t/p/w$imageWidth${this.backdropPath}"
    }
}