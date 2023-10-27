package co.tiagoaguiar.tutorial.jokerappdev.models

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("value")
    val text: String,
    @SerializedName("url_icon")
    val urlIcon: String
)
