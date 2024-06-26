package com.example.myfilsms.data

import com.example.myfilsms.data.dao.FilmDao
import com.example.myfilsms.data.entity.Film
import io.reactivex.rxjava3.core.Observable


class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}