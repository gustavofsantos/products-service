package com.ecommerce.services

import com.ecommerce.dtos.CreateProductRequestData
import com.ecommerce.repositories.ProductsRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class ProductsServiceImplTest {

    @Inject
    lateinit var productsRepository: ProductsRepository

    @Test
    fun `should create a product`() {
        val productsService = ProductsServiceImpl(productsRepository)

        val request = CreateProductRequestData(name = "Product one", price = 10.03, quantityInStock = 5)
        val result = productsService.create(request)

        Assertions.assertEquals("Product one", result.name)
        Assertions.assertEquals(10.03, result.price)
        Assertions.assertEquals(5, result.quantityInStock)
    }
}