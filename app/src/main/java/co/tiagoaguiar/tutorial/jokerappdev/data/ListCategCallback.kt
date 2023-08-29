package co.tiagoaguiar.tutorial.jokerappdev.data

interface ListCategCallback {

    fun onSucess(response: List<String>)

    fun onFailure(response: String)

    fun onComplete()

}