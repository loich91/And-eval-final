package com.example.and_eval_final_loic_hubermont.model


import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val resultMovies: List<ResultMovie>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)