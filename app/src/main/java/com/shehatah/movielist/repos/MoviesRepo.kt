package com.shehatah.movielist.repos

import com.shehatah.movielist.data.models.MovieResponse

interface MoviesRepo {
    suspend fun getPopularMovies(
        page: Int
    ): MovieResponse
}