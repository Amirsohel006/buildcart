package com.buildcart.app.modules.homeone.data

import com.buildcart.app.data.response.ProductCategoriesResponseData
import com.buildcart.app.service.APIInterface
import retrofit2.Response

class CategoriesRepository(private val apiService: APIInterface) {

    suspend fun getCategories(): Response<ProductCategoriesResponseData> {
        return apiService.getAllCategories() // Assuming getProductCategories() is a function in your ApiService
    }
}
