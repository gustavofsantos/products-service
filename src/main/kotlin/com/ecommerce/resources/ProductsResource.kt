package com.ecommerce.resources

import com.ecommerce.CreateProductReply
import com.ecommerce.CreateProductRequest
import com.ecommerce.ProductsServiceGrpc
import com.ecommerce.dtos.CreateProductRequestData
import com.ecommerce.services.ProductsService
import io.grpc.stub.StreamObserver
import io.micronaut.grpc.annotation.GrpcService

@GrpcService
class ProductsResource(private val productsService: ProductsService) : ProductsServiceGrpc.ProductsServiceImplBase() {
  override fun create(request: CreateProductRequest?, responseObserver: StreamObserver<CreateProductReply>?) {
      if (request == null) {
          responseObserver?.onCompleted()
          return
      }

    val productRequestData = CreateProductRequestData(
        name = request.name,
        price = request.price,
        quantityInStock = request.quantityInStock
    )

      val responseData = productsService.create(productRequestData)

      val responseMessage = CreateProductReply.newBuilder()
          .setId(responseData.id)
          .setName(responseData.name)
          .setPrice(responseData.price)
          .setQuantityInStock(responseData.quantityInStock)
          .build()

      responseObserver?.onNext(responseMessage)
      responseObserver?.onCompleted()
  }
}
