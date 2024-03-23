package com.example.myfilsms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfilsms.App
import com.example.myfilsms.data.entity.Film
import com.example.myfilsms.domain.Interactor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors
import javax.inject.Inject


class HomeFragmentViewModel : ViewModel() {
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Observable<List<Film>>
    val showProgressBar: BehaviorSubject<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }
}