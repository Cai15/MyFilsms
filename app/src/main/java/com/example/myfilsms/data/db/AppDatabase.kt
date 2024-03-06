package com.example.myfilsms.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfilsms.data.dao.FilmDao
import com.example.myfilsms.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}