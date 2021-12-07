package com.example.spacexmavericks.dagger

import com.example.spacexmavericks.repository.LaunchesRepository
import com.example.spacexmavericks.repository.impl.LaunchesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindLaunchesRepository(impl: LaunchesRepositoryImpl): LaunchesRepository
}