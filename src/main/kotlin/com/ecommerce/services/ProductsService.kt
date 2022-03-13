package com.ecommerce.services

import com.ecommerce.dtos.CreateProductReplyData
import com.ecommerce.dtos.CreateProductRequestData

interface ProductsService {
    fun create(request: CreateProductRequestData): CreateProductReplyData
}