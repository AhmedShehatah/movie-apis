package com.shehatah.movielist.di

import com.shehatah.movielist.data.ApiService
import com.shehatah.movielist.repos.MoviesRepo
import com.shehatah.movielist.repos.MoviesRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun providePopularMoviesRepo(apiService: ApiService): MoviesRepo {
        return MoviesRepoImpl(apiService)
    }
}