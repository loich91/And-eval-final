package com.example.and_eval_final_loic_hubermont.callApi

import com.example.and_eval_final_loic_hubermont.model.MovieData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ConnexionMovie {
    @Headers("Content-type: application/json")
    @GET("/3/search/movie")
    suspend fun searchMovie(
        @Query("api_key", encoded = true)api_key:String="b2168bae3a2c67509eb6b97572f521c2",
        @Query("query",encoded = false)query:String
    ):Response<MovieData>

    @Headers("Content-type: application/json")
    @GET("/3//movie/{movie_id}/similar")
    suspend fun searchMoviebyid(

        @Path("movie_id",encoded = false)movie_id:String,
        @Query("api_key", encoded = true)api_key:String="b2168bae3a2c67509eb6b97572f521c2"
    ):Response<MovieData>
    @Headers("Content-type: application/json")
    @GET("/3//trending/movie/week")
    suspend fun searchtrending(
        @Query("api_key", encoded = true)api_key:String="b2168bae3a2c67509eb6b97572f521c2"
    ):Response<MovieData>

}
