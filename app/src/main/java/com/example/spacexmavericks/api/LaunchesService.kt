package com.example.spacexmavericks.api

import com.example.spacexmavericks.GetLatestLaunchesQuery

interface LaunchesService {
    suspend fun getLatestLaunches(): GetLatestLaunchesQuery.Data?
}