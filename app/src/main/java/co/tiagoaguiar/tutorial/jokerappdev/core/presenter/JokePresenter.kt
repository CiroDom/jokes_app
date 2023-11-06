package co.tiagoaguiar.tutorial.jokerappdev.core.presenter

import co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces.OurCallbacks
import co.tiagoaguiar.tutorial.jokerappdev.core.data.remote_data_sources.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke
import co.tiagoaguiar.tutorial.jokerappdev.views.frags.JokeFrag

class JokePresenter(
    private val view: JokeFrag,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : OurCallbacks {

    override fun onSucessCateg(response: List<String>) {
        /** Nothing to do here */
    }

    override fun onSucessRandomJoke(response: Joke) {
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

    fun findRandomJoke() {
        view.showProgBar()
        dataSource.findRandomJoke(this)
    }

}