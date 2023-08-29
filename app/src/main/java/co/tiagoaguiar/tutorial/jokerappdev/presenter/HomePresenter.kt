package co.tiagoaguiar.tutorial.jokerappdev.presenter

import co.tiagoaguiar.tutorial.jokerappdev.data.CategRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategCallback
import co.tiagoaguiar.tutorial.jokerappdev.models.Category
import co.tiagoaguiar.tutorial.jokerappdev.views.frags.HomeFrag

class HomePresenter(
    private val view: HomeFrag,
    private val dataSource: CategRemoteDataSource = CategRemoteDataSource(),
    ) : ListCategCallback{

    override fun onSucess(response: List<String>) {
        val categories = response.map { category -> Category(category, 0xFFFF0000) }

        view.showCategs(categories)
    }

    override fun onFailure(messege: String) {
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