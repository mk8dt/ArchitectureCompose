package com.mk.architecture.mockdata

import com.mk.architecture.core.network.Endpoints
import com.mk.architecture.home.domain.models.Product
import javax.inject.Inject

class MockEndpoints @Inject constructor() : Endpoints {

    override suspend fun fetchData(): List<Product> = productList()

}