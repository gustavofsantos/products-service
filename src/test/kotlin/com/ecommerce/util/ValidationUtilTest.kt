package com.ecommerce.util

import com.ecommerce.CreateProductRequest
import com.ecommerce.errors.IllegalProductNameException
import com.ecommerce.errors.IllegalProductNullException
import com.ecommerce.errors.IllegalProductPriceNaNException
import com.ecommerce.errors.IllegalProductPriceNegativeException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ValidationUtilTest {

    @Test
    fun `should validate successfully with valid data`() {
        val request = CreateProductRequest.newBuilder()
            .setName("Product name")
            .setPrice(100.00)
            .setQuantityInStock(5)
            .build()

        Assertions.assertDoesNotThrow {
            ValidationUtil.validatePayload(request)
        }
    }


    @Test
    fun `should throw exception when product name is blank`() {
        val request = CreateProductRequest.newBuilder()
            .setName("")
            .setPrice(100.00)
            .setQuantityInStock(5)
            .build()

        Assertions.assertThrows(IllegalProductNameException::class.java) {
            ValidationUtil.validatePayload(request)
        }
    }

    @Test
    fun `should throw exception when product price is not a number`() {
        val request = CreateProductRequest.newBuilder()
            .setName("Product name")
            .setPrice(Double.NaN)
            .setQuantityInStock(5)
            .build()

        Assertions.assertThrows(IllegalProductPriceNaNException::class.java) {
            ValidationUtil.validatePayload(request)
        }
    }

    @Test
    fun `should throw exception when product price is negative`() {
        val request = CreateProductRequest.newBuilder()
            .setName("Product name")
            .setPrice(-100.00)
            .setQuantityInStock(5)
            .build()

        Assertions.assertThrows(IllegalProductPriceNegativeException::class.java) {
            ValidationUtil.validatePayload(request)
        }
    }

    @Test
    fun `should throw when request is null`() {
        Assertions.assertThrows(IllegalProductNullException::class.java) {
            ValidationUtil.validatePayload(null)
        }
    }
}