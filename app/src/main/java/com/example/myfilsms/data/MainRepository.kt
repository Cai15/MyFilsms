package com.example.myfilsms.data

import com.example.myfilsms.R
import com.example.myfilsms.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film("1+1",
            R.drawable.odin_odin, "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си", 5.0f),
        Film("Бойцовский коуб",
            R.drawable.boi_klub, "Страховой работник разрушает рутину своей благополучной жизни. Культовая драма по книге Чака Паланика", 3.0f),
        Film("Иван Васильевич меняет профессию (1973)",
            R.drawable.ivan_prof, "Иван Грозный отвечает на телефон, пока его тезка-пенсионер сидит на троне. Советский хит о липовом государе", 7.0f),
        Film("Шерлок Холмс и доктор Ватсон: Знакомство (ТВ, 1979)",
            R.drawable.sherlock_holms,"Увлекательные приключения самого известного сыщика всех времен",7.7f),
        Film( "Ходячий замок (2004)", R.drawable.hodit_zamok, "Анимэ", 9.0f),
        Film("Операция «Ы» и другие приключения Шурика (1965)",
            R.drawable.oper_i, "Похождения хронически оптимистичного очкарика. Блистательная комедия Леонида Гайдая",7f),
        Film("Матрица (1999)",
            R.drawable.matrica, "Жизнь Томаса Андерсона разделена на две части: днём он — самый обычный офисный работник, получающий нагоняи от начальства, а ночью превращается в хакера по имени Нео, и нет места в сети, куда он бы не смог проникнуть. Но однажды всё меняется. Томас узнаёт ужасающую правду о реальности.",2.0f)
    )
}