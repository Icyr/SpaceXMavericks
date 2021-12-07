package com.example.spacexmavericks.dagger

import com.airbnb.mvrx.MavericksViewModel
import com.example.spacexmavericks.feature.latest.LatestModule
import dagger.Component

@Component(modules = [RepositoryModule::class, LatestModule::class])
interface AppComponent {
    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}