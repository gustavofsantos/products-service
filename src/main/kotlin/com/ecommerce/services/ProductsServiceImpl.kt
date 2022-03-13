package com.ecommerce.services

import com.ecommerce.domains.Product
import com.ecommerce.dtos.CreateProductReplyData
import com.ecommerce.dtos.CreateProductRequestData
import com.ecommerce.repositories.ProductsRepository
import jakarta.inject.Singleton

@Singleton
class ProductsServiceImpl(private val productsRepository: ProductsRepository) : ProductsService {
    override fun create(request: CreateProductRequestData): CreateProductReplyData {
        val product = Product(
            id = null,
            name = request.name,
            price = request.price,
            quantityInStock = request.quantityInStock
        )

        return when (val productCreated = productsRepository.save(product)) {
            is Product -> CreateProductReplyData(
                id = productCreated.id!!,
                name = productCreated.name,
                price = productCreated.price,
                quantityInStock = productCreated.quantityInStock
            )
            else -> throw Error("Product not created")
        }

    }
}