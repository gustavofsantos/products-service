package com.ecommerce.repositories

import com.ecommerce.domains.Product
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import jakarta.inject.Singleton

@Singleton
@Repository
interface ProductsRepository : JpaRepository<Product, Long>