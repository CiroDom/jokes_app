package co.tiagoaguiar.tutorial.jokerappdev.data

interface ListCategCallbacks {

    fun onSucess(response: List<String>)

    fun onError(response: String)

    fun onComplete()

}