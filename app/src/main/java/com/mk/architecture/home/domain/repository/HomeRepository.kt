package com.mk.architecture.home.domain.repository

import com.mk.architecture.home.domain.models.Product

interface HomeRepository {

    suspend fun fetchData(): Result<List<Product>>
}