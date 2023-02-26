package com.tarasov_denis.tarasov_lesson2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentMainBinding
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentOfficesBinding



/**
 * A simple [Fragment] subclass.
 * Use the [OfficesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OfficesFragment : Fragment() {

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

 */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val binding = FragmentOfficesBinding.inflate(inflater, container, false)

       // return inflater.inflate(R.layout.fragment_offices, container, false)
        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val listOfCities = listOf("Москва", "Минск", "Санкт-Петербург", "Ростов-на-Дону", "Казань",
        "Алматы", "Гомель", "Витебск", "Полоцк")

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view_office)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        //recyclerView?.adapter = RecyclerAdapterOffices(listOfCities)
// не запускается фрагмент DetailOffice
        // https://medium.com/@DinaTAKLIT/fragment-inside-a-fragmet-e23592c90025
        recyclerView?.adapter = RecyclerAdapterOffices(listOfCities){ String ->
            Log.d("Denis", String)
            val fragment = DetailOfficeFragment()

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_detail_office, DetailOfficeFragment())
                .commit()
            /*
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_offices,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

             */
               // .replace(R.id.fragment_container_view, DetailOfficeFragment())
               // .addToBackStack(null)


           // goToDetail()
            //Here, 'dataClass' will be the clicked item on recyclerView. Here you can do any logic that's supposed to happen after the click, like opening a new fragment passing 'dataClass' as parameter.

          //  val transaction = childFragmentManager.beginTransaction()
          //  transaction.replace(R.id.fragment_detail_office, DetailOfficeFragment()).commit()

        }



    }

    fun goToDetail() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, DetailOfficeFragment())
            .addToBackStack(null)
            .commit()
    }
/*
fun Fragment.addChildFragment(fragment: Fragment, frameId: Int) { // в аргументы добавляем дочерний фрагмент

val transaction = childFragmentManager.beginTransaction()
transaction.replace(frameId, fragment).commit()
}
 */


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