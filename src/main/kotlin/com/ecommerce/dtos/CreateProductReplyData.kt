package com.ecommerce.dtos

import io.micronaut.core.annotation.Introspected

@Introspected
data class CreateProductReplyData(
    val id: Long,
    val name: String,
    val price: Double,
    val quantityInStock: Int
)