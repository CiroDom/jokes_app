package co.tiagoaguiar.tutorial.jokerappdev.presenter

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.models.Joke
import co.tiagoaguiar.tutorial.jokerappdev.views.frags.JokeFrag

class JokePresenter(
    private val view: JokeFrag,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    override fun onSucess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgBar()
    }

    fun findByCateg(categName: String) {
        view.showProgBar()
        dataSource.findByCateg(categName, this)
    }

}