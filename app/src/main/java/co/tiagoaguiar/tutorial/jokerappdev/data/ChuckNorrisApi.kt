package co.tiagoaguiar.tutorial.jokerappdev.data

import co.tiagoaguiar.tutorial.jokerappdev.models.Joke
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

}