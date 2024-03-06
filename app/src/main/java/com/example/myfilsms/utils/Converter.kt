package com.example.myfilsms.utils

import com.example.myfilsms.data.entity.TmdbFilm
import com.example.myfilsms.data.entity.Film

object Converter {
    fun convertApiListToDTOList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(
                Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            )
            )
        }
        return result
    }
}