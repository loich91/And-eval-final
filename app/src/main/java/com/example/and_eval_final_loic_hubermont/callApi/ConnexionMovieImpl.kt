package com.example.and_eval_final_loic_hubermont.callApi

import com.example.and_eval_final_loic_hubermont.model.MovieData
import retrofit2.Response

class ConnexionMovieImpl : AppRetroMovie() {
    suspend fun getMovie(query:String):Response<MovieData> = getRetrofit().create(ConnexionMovie::class.java).searchMovie(query=query)
    suspend fun getMtrending():Response<MovieData> = getRetrofit().create(ConnexionMovie::class.java).searchtrending()
}