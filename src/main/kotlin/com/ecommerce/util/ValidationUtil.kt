package com.ecommerce.util

import com.ecommerce.CreateProductRequest
import com.ecommerce.errors.IllegalProductNameException
import com.ecommerce.errors.IllegalProductNullException
import com.ecommerce.errors.IllegalProductPriceNaNException
import com.ecommerce.errors.IllegalProductPriceNegativeException

class ValidationUtil {
    companion object {
        fun validatePayload(payload: CreateProductRequest?): CreateProductRequest {
            if (payload == null)
                throw IllegalProductNullException()


            payload.let { product ->
                if (product.name.isNullOrBlank())
                    throw IllegalProductNameException()

                if (product.price.isNaN())
                    throw IllegalProductPriceNaNException()

                if (product.price < 0)
                    throw IllegalProductPriceNegativeException()

                return product
            }
        }
    }
}