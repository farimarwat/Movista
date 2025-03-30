package com.farimarwat.movista.domain.model

data class Series(
    val adult: Boolean,
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
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