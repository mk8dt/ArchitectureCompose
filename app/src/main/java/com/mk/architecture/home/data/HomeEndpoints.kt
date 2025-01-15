package com.mk.architecture.home.data

import com.mk.architecture.home.domain.models.Product

interface HomeEndpoints {

    suspend fun fetchData(): List<Product>
}