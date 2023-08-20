package com.shehatah.movielist.data

import com.shehatah.movielist.data.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse
}