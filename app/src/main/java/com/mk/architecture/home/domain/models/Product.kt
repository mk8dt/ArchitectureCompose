package com.mk.architecture.home.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("product_id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Double
)
