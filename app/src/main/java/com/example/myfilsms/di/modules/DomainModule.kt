package com.example.myfilsms.di.modules


import android.os.Parcel
import android.os.Parcelable
import com.example.myfilsms.data.MainRepository
import com.example.myfilsms.data.TmdbApi
import com.example.myfilsms.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule() {

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(response = repository, retrofitService = tmdbApi )

}