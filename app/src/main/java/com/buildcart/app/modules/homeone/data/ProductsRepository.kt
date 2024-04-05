package com.buildcart.app.modules.homeone.data

import com.buildcart.app.data.ProductDataResponse
import com.buildcart.app.modules.catogories.data.model.CategoryIdRequest
import com.buildcart.app.modules.homeone.data.model.ProductDetailsDataResponse
import com.buildcart.app.modules.homeone.data.model.ProductResponseData
import com.buildcart.app.service.APIInterface
import retrofit2.Response

class ProductsRepository(private val apiService: APIInterface) {

    // Method to fetch all products
    suspend fun getAllProducts(): ProductDataResponse {
        return apiService.getAllProducts()
    }

    // Method to add a product to the cart
    suspend fun addProductToCart(
        authorization: String,
        addToCartRequestBody: AddToCartRequestBody
    ): Response<ProductDataResponse> {
        return apiService.addProductToCart(authorization, addToCartRequestBody)
    }


    suspend fun getProductDetailsById(authorization: String,productId: String):Response< ProductDetailsDataResponse> {
        return apiService.getProductDetailsByProductID(authorization,productId)
    }

    suspend fun getProductByCategories(authorization: String,productId: CategoryIdRequest): ProductDataResponse {
        return apiService.showProductsByCategory(authorization,productId)
    }

    // Other methods for interacting with the data source

}
