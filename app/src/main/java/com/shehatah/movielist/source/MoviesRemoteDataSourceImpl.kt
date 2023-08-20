package com.shehatah.movielist.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shehatah.movielist.data.models.Result
import com.shehatah.movielist.paging.MoviesPagingSource
import com.shehatah.movielist.repos.MoviesRepo
import kotlinx.coroutines.flow.Flow

class MoviesRemoteDataSourceImpl(private val repo: MoviesRepo) : MoviesRemoteDataSource {
    override fun getPopularMovies(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 25,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                MoviesPagingSource(repo = repo)
            }
        ).flow
    }
}