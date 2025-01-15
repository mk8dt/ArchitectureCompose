package com.mk.architecture.home.data

import com.mk.architecture.core.manager.error.ErrorManager
import com.mk.architecture.core.network.Endpoints
import com.mk.architecture.home.domain.models.Product
import com.mk.architecture.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val endpoints: Endpoints,
    private val errorManager: ErrorManager
) : HomeRepository {

    override suspend fun fetchData(): Result<List<Product>> =
        runCatching {
            endpoints.fetchData()
        }.recoverCatching {
            throw errorManager.handle(it)
        }
}
