package co.tiagoaguiar.tutorial.jokerappdev.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {

    @GET("jokes/categories")
    fun findAllCategs(@Query("apiKey") apiKey: String = HttpClient.API_KEY) : Call<List<String>>

}