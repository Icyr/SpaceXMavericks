package com.example.spacexmavericks.dagger

import com.airbnb.mvrx.MavericksViewModel
import com.example.spacexmavericks.api.ApiModule
import com.example.spacexmavericks.api.NetworkModule
import com.example.spacexmavericks.feature.latest_launches.LatestLaunchesModule
import com.example.spacexmavericks.repository.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        ApiModule::class,
        RepositoryModule::class,
        LatestLaunchesModule::class
    ]
)
@Singleton
interface AppComponent {
    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}