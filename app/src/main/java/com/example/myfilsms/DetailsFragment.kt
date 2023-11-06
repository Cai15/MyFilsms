package com.example.myfilsms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myfilsms.databinding.FragmentDetailsBinding



class DetailsFragment : Fragment() {
    private var fragbinding: FragmentDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragbinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return fragbinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        fragbinding!!.detailsToolbar.title = film.title
        //Устанавливаем картинку
        fragbinding!!.detailsPoster.setImageResource(film.poster)
        //Устанавливаем описание
        fragbinding!!.detailsDescription.text = film.description
    }
}