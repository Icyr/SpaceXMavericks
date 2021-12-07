package com.example.spacexmavericks.repository

import com.example.spacexmavericks.repository.impl.LaunchesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    fun bindLaunchesRepository(impl: LaunchesRepositoryImpl): LaunchesRepository

    companion object {
        @Provides
        fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}