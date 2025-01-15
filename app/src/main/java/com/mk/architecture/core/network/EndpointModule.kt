package com.mk.architecture.core.network

import com.mk.architecture.mockdata.MockEndpoints
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EndpointModule {

    @Binds
    abstract fun bindEndpoints(
        mockEndpoints: MockEndpoints
    ): Endpoints
}