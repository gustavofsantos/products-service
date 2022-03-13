package com.ecommerce.resources

import com.ecommerce.CreateProductRequest
import com.ecommerce.ProductsServiceGrpc.ProductsServiceBlockingStub
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class ProductsResourceTest {

    @Inject
    lateinit var productsServiceBlockingStub: ProductsServiceBlockingStub

    @Test
    fun `should create a product when call with valid creation data`() {
        val request = CreateProductRequest.newBuilder()
            .setName("Product name")
            .setPrice(10.99)
            .setQuantityInStock(10)
            .build()

        val response = productsServiceBlockingStub.create(request)

        Assertions.assertEquals(1, response.id)
        Assertions.assertEquals("Product name", response.name)
        Assertions.assertEquals(10.99, response.price)
        Assertions.assertEquals(10, response.quantityInStock)
    }
}