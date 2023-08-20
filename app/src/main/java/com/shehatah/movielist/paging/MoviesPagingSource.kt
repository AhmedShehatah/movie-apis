package com.shehatah.movielist.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shehatah.movielist.data.models.Result
import com.shehatah.movielist.repos.MoviesRepo

class MoviesPagingSource(private val repo: MoviesRepo) : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageIndex = params.key ?: 1
        return try {
            val response = repo.getPopularMovies(
                page = pageIndex
            )
            val movies = response.results
            val nextKey =
                if (movies.isEmpty()) {
                    null
                } else {
                    pageIndex + (params.loadSize / 25)
                }
            LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == 1) null else pageIndex,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }

    }
}