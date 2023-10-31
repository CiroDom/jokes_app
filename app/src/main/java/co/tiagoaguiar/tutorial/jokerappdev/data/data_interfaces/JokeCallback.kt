package co.tiagoaguiar.tutorial.jokerappdev.data.data_interfaces

import co.tiagoaguiar.tutorial.jokerappdev.models.Joke

interface JokeCallback {

    fun onSucess(response: Joke)

    fun onError(response: String)

    fun onComplete()

}