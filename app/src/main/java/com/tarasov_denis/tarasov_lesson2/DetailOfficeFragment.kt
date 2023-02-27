package com.tarasov_denis.tarasov_lesson2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentDetailOfficeBinding
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentOfficesBinding


class DetailOfficeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailOfficeBinding.inflate(inflater, container, false)
        binding.address.text = adresses.getValue(MainActivity.selectedCity)

        return binding.root
        //return inflater.inflate(R.layout.fragment_detail_office, container, false)
    }

    val adresses = mapOf(
        "Москва" to "Москва, Пресненская набережная, д.6, стр. 2, БЦ «Башня Империя», 3 подъезд, 53 этаж, офис 13",
        "Минск" to "Минск, пр-т Победителей, 7А",
        "Санкт-Петербург" to "Санкт-Петербург, Владимирский проспект, 23, БЦ «Ренессанс Холл», 8 этаж, 801",
        "Ростов-на-Дону" to "Ростов-на-Дону, ул. Текучева, 246, 3 этаж",
        "Казань" to "Казань, ул. Н. Ершова, 76/1, оф. 213",
        "Алматы" to "Алматы, Бостандыкский район, микрорайон Коктем-2, здание 22",
        "Гомель" to "Гомель, ул. Советская, 41Б",
        "Витебск" to "Витебск, ул. Строителей, 11А",
        "Полоцк" to "Полоцк, ул. Октябрьская, 25"
        )


}



/*
Москва, Пресненская набережная, д.6, стр. 2, БЦ «Башня Империя», 3 подъезд, 53 этаж, офис 13
Минск, пр-т Победителей, 7А
Санкт-Петербург, Владимирский проспект, 23, БЦ «Ренессанс Холл», 8 этаж, 801
Ростов-на-Дону, ул. Текучева, 246, 3 этаж
Казань, ул. Н. Ершова, 76/1, оф. 213
Алматы, Бостандыкский район, микрорайон Коктем-2, здание 22
Гомель, ул. Советская, 41Б
Витебск, ул. Строителей, 11А;
Московский проспект, 70, корп.1
Полоцкс, ул. Октябрьская, 25

 */