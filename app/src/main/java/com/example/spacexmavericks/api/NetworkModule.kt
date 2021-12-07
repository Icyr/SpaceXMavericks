package com.example.spacexmavericks.api

import com.apollographql.apollo.ApolloClient
import com.example.spacexmavericks.type.CustomType
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://api.spacex.land/graphql/")
            .addCustomTypeAdapter(CustomType.DATE, GraphQlDateTimeTypeAdapter())
            .build()
    }
}