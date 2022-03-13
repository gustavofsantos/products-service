package com.ecommerce.config

import com.ecommerce.ProductsServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import jakarta.inject.Singleton

@Factory
class GrpcConfig {
    @Singleton
    fun productsServiceBean(@GrpcChannel("productsService") channel: ManagedChannel): ProductsServiceGrpc.ProductsServiceBlockingStub {
        return ProductsServiceGrpc.newBlockingStub(channel)
    }
}