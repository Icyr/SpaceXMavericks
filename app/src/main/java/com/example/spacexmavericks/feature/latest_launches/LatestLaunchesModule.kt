package com.example.spacexmavericks.feature.latest_launches

import com.example.spacexmavericks.dagger.AssistedViewModelFactory
import com.example.spacexmavericks.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LatestLaunchesModule {

    @Binds
    @IntoMap
    @ViewModelKey(LatestLaunchesViewModel::class)
    fun latestViewModelFactory(factory: LatestLaunchesViewModel.Factory): AssistedViewModelFactory<*, *>
}