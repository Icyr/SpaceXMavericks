package com.example.spacexmavericks.feature.latest_launches

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.spacexmavericks.dagger.AssistedViewModelFactory
import com.example.spacexmavericks.dagger.daggerMavericksViewModelFactory
import com.example.spacexmavericks.repository.LaunchesRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class LatestLaunchesViewModel @AssistedInject constructor(
    @Assisted state: LatestLaunchesState,
    private val launchesRepository: LaunchesRepository
) : MavericksViewModel<LatestLaunchesState>(state) {

    init {
        suspend {
            launchesRepository.loadLatestLaunches()
        }.execute { copy(launches = it) }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<LatestLaunchesViewModel, LatestLaunchesState> {
        override fun create(state: LatestLaunchesState): LatestLaunchesViewModel
    }

    companion object : MavericksViewModelFactory<LatestLaunchesViewModel, LatestLaunchesState> by daggerMavericksViewModelFactory()
}