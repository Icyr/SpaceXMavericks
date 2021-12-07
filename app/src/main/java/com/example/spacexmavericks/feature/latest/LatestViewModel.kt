package com.example.spacexmavericks.feature.latest

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.spacexmavericks.dagger.AssistedViewModelFactory
import com.example.spacexmavericks.dagger.daggerMavericksViewModelFactory
import com.example.spacexmavericks.repository.LaunchesRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class LatestViewModel @AssistedInject constructor(
    @Assisted state: LatestState,
    private val launchesRepository: LaunchesRepository
) : MavericksViewModel<LatestState>(state) {

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<LatestViewModel, LatestState> {
        override fun create(state: LatestState): LatestViewModel
    }

    companion object : MavericksViewModelFactory<LatestViewModel, LatestState> by daggerMavericksViewModelFactory()
}