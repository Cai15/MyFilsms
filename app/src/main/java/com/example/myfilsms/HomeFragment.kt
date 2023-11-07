package com.example.myfilsms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfilsms.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding


    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase: List<Film>
        get() = listOf(
            Film("1+1", R.drawable.odin_odin, "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си"),
            Film("Бойцовский коуб", R.drawable.boi_klub, "Страховой работник разрушает рутину своей благополучной жизни. Культовая драма по книге Чака Паланика"),
            Film("Иван Васильевич меняет профессию (1973)", R.drawable.ivan_prof, "Иван Грозный отвечает на телефон, пока его тезка-пенсионер сидит на троне. Советский хит о липовом государе"),
            Film("Шерлок Холмс и доктор Ватсон: Знакомство (ТВ, 1979)",R.drawable.sherlock_holms,"Увлекательные приключения самого известного сыщика всех времен"),
            Film("Ходячий замок (2004)",R.drawable.hodit_zamok, "Анимэ"),
            Film("Операция «Ы» и другие приключения Шурика (1965)", R.drawable.oper_i, "Похождения хронически оптимистичного очкарика. Блистательная комедия Леонида Гайдая"),
            Film("Матрица (1999)", R.drawable.matrica, "Жизнь Томаса Андерсона разделена на две части: днём он — самый обычный офисный работник, получающий нагоняи от начальства, а ночью превращается в хакера по имени Нео, и нет места в сети, куда он бы не смог проникнуть. Но однажды всё меняется. Томас узнаёт ужасающую правду о реальности.")
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding = FragmentHomeBinding.inflate(layoutInflater)
        //находим наш RV
        binding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
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

            //Кладем нашу БД в RV
            filmsAdapter.addItems(filmsDataBase)
        }
    }
}



