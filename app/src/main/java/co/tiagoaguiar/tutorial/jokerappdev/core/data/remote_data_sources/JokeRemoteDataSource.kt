package co.tiagoaguiar.tutorial.jokerappdev.core.data.remote_data_sources

import android.util.Log
import co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces.ChuckNorrisApi
import co.tiagoaguiar.tutorial.jokerappdev.core.data.http_singleton.HttpClient
import co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces.OurCallbacks
import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class JokeRemoteDataSource {

    fun findByCateg(categName: String, callback: OurCallbacks) {
        HttpClient.buildRetrofit()
            .create(ChuckNorrisApi::class.java)
            .findByCateg(categName)
            .enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful) {
                        val joke = response.body()
                        callback.onSucessRandomJoke(joke ?: throw RuntimeException("Piada não encontrada"))
                        Log.d("JokeRemoteDataSource", "onSuccess")
                    } else {
                        val error =
                            if (response.errorBody() != null) {
                                response.errorBody().toString()
                            } else {
                                "erro desconhecido"
                            }
                        callback.onError("Erro na chamada: $error")
                        Log.e("JokeRemoteDataSource", "onError: $error")
                    }
                    callback.onComplete()
                    Log.d("JokeDataSource", "onComplete")
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    Log.e("JokeRemoteDataSource", "onFailure: ${t.message ?: "Erro interno"}")
                    callback.onComplete()
                    Log.d("JokeRemoteDataSource", "onComplete")
                }

            })
    }

    fun findRandomJoke(callback: OurCallbacks) {
        HttpClient.buildRetrofit()
            .create(ChuckNorrisApi::class.java)
            .findDayJoke()
            .enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful) {
                        val joke = response.body()
                        callback.onSucessRandomJoke(joke ?: throw RuntimeException("Piada não encontrada"))
                        Log.d("JokeRemoteDataSource", "onSuccess")
                    } else {
                        val error =
                            if (response.errorBody() != null) {
                                response.errorBody().toString()
                            } else {
                                "erro desconhecido"
                            }
                        callback.onError("Erro na chamada: $error")
                        Log.e("JokeRemoteDataSource", "onError: $error")
                    }
                    callback.onComplete()
                    Log.d("JokeDataSource", "onComplete")
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                    Log.e("JokeRemoteDataSource", "onFailure: ${t.message ?: "Erro interno"}")
                    callback.onComplete()
                    Log.d("JokeRemoteDataSource", "onComplete")
                }
            })
    }
}