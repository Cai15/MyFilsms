package com.example.myfilsms.domain

import com.example.myfilsms.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}