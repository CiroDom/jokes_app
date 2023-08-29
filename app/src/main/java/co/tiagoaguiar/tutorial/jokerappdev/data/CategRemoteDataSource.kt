package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper

class CategRemoteDataSource {

    fun findAllCategs(callback: ListCategCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val simulatedResponse = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4",
            )

            callback.onSucess(simulatedResponse)

            callback.onComplete()
        }, 2000)
    }

}