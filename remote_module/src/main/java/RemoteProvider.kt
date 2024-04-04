package ru.MyFilsms.remote_module

interface RemoteProvider {
    fun provideRemote(): TmdbApi
}