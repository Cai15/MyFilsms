package com.example.myfilsms.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfilsms.view.rv_adapters.FilmListRecyclerAdapter
import com.example.myfilsms.R
import com.example.myfilsms.view.rv_adapters.TopSpacingItemDecoration
import com.example.myfilsms.databinding.FragmentFavoritesBinding
import com.example.myfilsms.domain.Film
import com.example.myfilsms.utils.AnimationHelper
import com.example.myfilsms.view.MainActivity


class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private lateinit var binding: FragmentFavoritesBinding

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Получаем список при транзакции фрагмента
        val favoritesList: List<Film> = emptyList()

        AnimationHelper.performFragmentCircularRevealAnimation(binding.favoritesFragmentRoot, requireActivity(),2)

        binding.favoritesRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(favoritesList)
    }
}
