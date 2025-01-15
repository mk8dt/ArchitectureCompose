package com.mk.architecture.mockdata

import com.mk.architecture.home.domain.models.Product

fun productList() = listOf(
    Product(0, "Pintura Rojo Khorne", 2.75),
    Product(1, "Pintura Blanco Roto", 2.50),
    Product(2, "Pintura Negro Chaos", 3.75),
)