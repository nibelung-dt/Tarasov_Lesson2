package com.tarasov_denis.tarasov_lesson2

interface CustomViews {

    fun createListOfCustomViews(listOfTitles: List<String>, listOfSubtitles: List<String>): List<CustomViews.MyViews>

    class MyViews(val title: String, val subtitle: String) : CustomViews {

        override fun createListOfCustomViews(listOfTitles: List<String>, listOfSubtitles: List<String>) : List<CustomViews.MyViews>{
             val list = mutableListOf<CustomViews.MyViews>()
              for (i in listOfTitles.indices) {
                val newCustomView = MyViews(title = listOfTitles[i], subtitle = listOfSubtitles[i])
                list.add(newCustomView)
                }
            return list
        }
    }

    class Base : CustomViews {
        override fun createListOfCustomViews(listOfTitles: List<String>, listOfSubtitles: List<String>) : List<CustomViews.MyViews>{
            val list = mutableListOf<CustomViews.MyViews>()
            for (i in listOfTitles.indices) {
                val newCustomView = MyViews(title = listOfTitles[i], subtitle = listOfSubtitles[i])
                list.add(newCustomView)
            }
            return list
        }
    }

}