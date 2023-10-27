package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.models.Joke

interface JokeCallback {

    fun onSucess(response: Joke)

    fun onError(response: String)

    fun onComplete()

}