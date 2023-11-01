package co.tiagoaguiar.tutorial.jokerappdev.core.data.data_interfaces

import co.tiagoaguiar.tutorial.jokerappdev.core.data.http_singleton.HttpClient
import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun findAllCategs(@Query("apiKey") apiKey: String = HttpClient.API_KEY) : Call<List<String>>

    @GET("jokes/random")
    fun findByCateg(
        @Query("category")
        categName: String,
        @Query("apiKey")
        apiKey: String = HttpClient.API_KEY
    ) : Call<Joke>

    @GET("jokes/random")
    fun findDayJoke(
        @Query("apiKey")
        apiKey: String = HttpClient.API_KEY
    ) : Call<Joke>
}