package com.example.myfilsms.data

import com.example.myfilsms.data.dao.FilmDao
import com.example.myfilsms.data.entity.Film
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()

}