package com.example.spacexmavericks.repository

import com.example.spacexmavericks.domain.Launch

interface LaunchesRepository {
    suspend fun loadLatestLaunches(): List<Launch>
}