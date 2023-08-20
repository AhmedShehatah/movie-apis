package com.shehatah.movielist.repos

import com.shehatah.movielist.data.ApiService
import com.shehatah.movielist.data.models.MovieResponse

class MoviesRepoImpl(private val apiService: ApiService) : MoviesRepo {
    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return apiService.getPopularMovies(page)
    }
}