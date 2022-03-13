package com.ecommerce.dtos

data class CreateProductRequestData(
    val name: String,
    val price: Double,
    val quantityInStock: Int
)
