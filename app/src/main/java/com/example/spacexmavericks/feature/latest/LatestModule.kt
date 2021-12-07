package com.example.spacexmavericks.feature.latest

import com.example.spacexmavericks.dagger.AssistedViewModelFactory
import com.example.spacexmavericks.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LatestModule {

    @Binds
    @IntoMap
    @ViewModelKey(LatestViewModel::class)
    fun latestViewModelFactory(factory: LatestViewModel.Factory): AssistedViewModelFactory<*, *>
}