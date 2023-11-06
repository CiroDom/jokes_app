package co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces

import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke

interface OurCallbacks {

    fun onSucessCateg(response: List<String>)

    fun onSucessRandomJoke(response: Joke)

    fun onError(response: String)

    fun onComplete()

}