package com.shehatah.movielist.source

import androidx.paging.PagingData
import com.shehatah.movielist.data.models.Result
import kotlinx.coroutines.flow.Flow

interface MoviesRemoteDataSource {
    fun getPopularMovies(): Flow<PagingData<Result>>
}