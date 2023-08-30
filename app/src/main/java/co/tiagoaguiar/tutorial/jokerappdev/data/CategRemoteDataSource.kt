package co.tiagoaguiar.tutorial.jokerappdev.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategRemoteDataSource {

    fun findAllCategs(callback: ListCategCallback) {
        HttpClient.buildRetrofit()
            .create(ChuckNorrisApi::class.java)
            .findAllCategs()
            .enqueue( object : Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if(response.isSuccessful) {
                        val categories = response.body()
                        callback.onSucess(categories ?: emptyList())
                    } else {
                        val error = if (response.errorBody() == null) {
                            response.errorBody().toString()
                        } else {
                            "erro desconhecido"
                        }

                        callback.onError("Erro na chamada: $error")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro no servidor")
                    callback.onComplete()
                }
            }
            )
    }

}