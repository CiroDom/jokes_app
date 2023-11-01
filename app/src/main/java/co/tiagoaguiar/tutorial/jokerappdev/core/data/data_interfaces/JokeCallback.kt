package co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces

import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke

interface JokeCallback {

    fun onSucess(response: Joke)

    fun onError(response: String)

    fun onComplete()

}