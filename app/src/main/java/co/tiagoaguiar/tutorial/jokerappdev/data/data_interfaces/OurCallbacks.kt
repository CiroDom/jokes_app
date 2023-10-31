package co.tiagoaguiar.tutorial.jokerappdev.data.data_interfaces

import co.tiagoaguiar.tutorial.jokerappdev.models.Joke

interface OurCallbacks {

    fun onSucessCateg(response: List<String>)

    fun onSucessDayJoke(response: Joke)

    fun onError(response: String)

    fun onComplete()

}