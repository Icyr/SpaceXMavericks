package com.example.spacexmavericks.repository.impl

import com.example.spacexmavericks.api.LaunchesService
import com.example.spacexmavericks.domain.Launch
import com.example.spacexmavericks.repository.LaunchesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val launchesService: LaunchesService
) : LaunchesRepository {

    override suspend fun loadLatestLaunches(): List<Launch> = withContext(ioDispatcher) {
        launchesService.getLatestLaunches()
            ?.launchesPast
            ?.mapNotNull {
                it?.run {
                    Launch(
                        id = id,
                        date = launch_date_local,
                        missionName = mission_name,
                        rocketName = rocket?.rocket_name
                    )
                }
            } ?: emptyList()
    }
}