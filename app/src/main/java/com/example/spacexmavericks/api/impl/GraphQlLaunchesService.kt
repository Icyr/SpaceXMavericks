package com.example.spacexmavericks.api.impl

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.example.spacexmavericks.GetLatestLaunchesQuery
import com.example.spacexmavericks.api.LaunchesService
import javax.inject.Inject

class GraphQlLaunchesService @Inject constructor(
    private val apolloClient: ApolloClient
) : LaunchesService {
    override suspend fun getLatestLaunches(): GetLatestLaunchesQuery.Data? {
        return apolloClient.query(GetLatestLaunchesQuery()).await().data
    }
}