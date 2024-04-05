package com.buildcart.app.modules.mycart.data.model

import com.buildcart.app.data.response.ProductCategoriesResponseData
import com.buildcart.app.service.APIInterface
import com.buildcart.app.service.APIManager
import retrofit2.Response

class CartRepository(private val apiService: APIInterface) {
    suspend fun getCartProducts(authorization: String,): Response<List<CartProductItem>> {
        return apiService.getCartProducts(authorization)
    }

}