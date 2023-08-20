package com.shehatah.movielist.di

import com.shehatah.movielist.repos.MoviesRepo
import com.shehatah.movielist.source.MoviesRemoteDataSource
import com.shehatah.movielist.source.MoviesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideMovieDataSource(repo: MoviesRepo): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(repo)
    }
}