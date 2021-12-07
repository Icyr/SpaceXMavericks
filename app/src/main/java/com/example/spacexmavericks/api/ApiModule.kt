package com.example.spacexmavericks.api

import com.example.spacexmavericks.api.impl.GraphQlLaunchesService
import dagger.Binds
import dagger.Module

@Module
interface ApiModule {

    @Binds
    fun bindLaunchesService(impl: GraphQlLaunchesService): LaunchesService
}