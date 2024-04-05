package com.buildcart.app.modules.homeone.data.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buildcart.app.data.ProductGalleryItem
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.modules.homeone.data.model.ProductDetailsDataResponse
import com.buildcart.app.modules.homeone.data.model.ProductImageGalleries
import com.buildcart.app.service.APIManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailsViewModel(private val productsRepository: ProductsRepository,) : ViewModel() {

    private val _productDetails = MutableLiveData<ProductDetailsDataResponse>()
    val productDetails: LiveData<ProductDetailsDataResponse> get() = _productDetails
    private lateinit var sessionManager: SessionManager

    fun setSessionManager(manager: SessionManager) {
        sessionManager = manager
    }

    // Fetch product details from the API
    fun fetchProductDetails(productId: String) {
        viewModelScope.launch {
            try {
                val token = sessionManager.fetchAuthToken()
                val authorization="Bearer $token"
                // Perform API call to get product details
                val response = productsRepository.getProductDetailsById(authorization,productId)

                if (response.isSuccessful) {
                    _productDetails.value = response.body()
                } else {
                    // Handle error case
                    // You may want to define a separate LiveData for error handling
                }

            } catch (e: Exception) {
                e.printStackTrace()
                // Handle exception
                // You may want to define a separate LiveData for error handling
            }
        }
    }

    fun getFullImageUrl(productGalleries: List<ProductImageGalleries>?): String {
        // Check if productGalleries is null before using it
        if (productGalleries != null) {
            val imageUrls = productGalleries.joinToString(",") { it.image.toString() }
            return APIManager.BASE_URL + imageUrls
        } else {
            // Handle the case where productGalleries is null
            return ""
        }
    }

}
