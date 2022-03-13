package com.ecommerce.util

import com.ecommerce.CreateProductRequest

class ValidationUtil {
    companion object {
        fun validatePayload(payload: CreateProductRequest?): CreateProductRequest {
            if (payload == null)
                throw IllegalArgumentException("Product is null")


            payload.let { product ->
                if (product.name.isNullOrBlank())
                    throw IllegalArgumentException("Product name is null or empty")

                if (product.price.isNaN())
                    throw IllegalArgumentException("Product price is not a number")

                return product
            }
        }
    }
}