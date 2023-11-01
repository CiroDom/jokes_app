package co.tiagoaguiar.tutorial.jokerappdev.core.presenter

import android.graphics.Color
import co.tiagoaguiar.tutorial.jokerappdev.core.data.remote_data_sources.CategRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces.OurCallbacks
import co.tiagoaguiar.tutorial.jokerappdev.core.models.Category
import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke
import co.tiagoaguiar.tutorial.jokerappdev.views.frags.HomeFrag

class HomePresenter(
    private val view: HomeFrag,
    private val dataSource: CategRemoteDataSource = CategRemoteDataSource(),
    ) : OurCallbacks {

    override fun onSucessCateg(response: List<String>) {
        val colorStart = 239
        val colorEnd = 40
        val grad = (colorStart - colorEnd) / response.size

        val categories = response.mapIndexed { index, string ->
            val hsv = floatArrayOf(
                colorStart - (grad * index).toFloat(),
                100.0f,
                100.0f,
            )

            Category(string, Color.HSVToColor(hsv).toLong())
        }

        view.showCategs(categories)
    }

    override fun onSucessDayJoke(response: Joke) {
        /** nothing to do here */
    }

    override fun onError(messege: String) {
        view.showFailure(messege)
    }

    override fun onComplete() {
        view.hideProgBar()
    }

    fun findAllCategs() {
        view.showProgBar()
        dataSource.findAllCategs(this)
    }

}