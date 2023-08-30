package co.tiagoaguiar.tutorial.jokerappdev.data

interface ListCategCallback {

    fun onSucess(response: List<String>)

    fun onError(response: String)

    fun onComplete()

}