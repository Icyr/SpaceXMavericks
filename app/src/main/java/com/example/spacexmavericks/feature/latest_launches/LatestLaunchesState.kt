package com.example.spacexmavericks.feature.latest_launches

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.example.spacexmavericks.domain.Launch

data class LatestLaunchesState(
    val launches: Async<List<Launch>> = Uninitialized
) : MavericksState
