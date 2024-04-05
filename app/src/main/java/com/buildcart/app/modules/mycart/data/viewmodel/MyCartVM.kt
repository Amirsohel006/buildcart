package com.buildcart.app.modules.mycart.`data`.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buildcart.app.data.ProductGalleryItem
import com.buildcart.app.data.ProductResponseItem
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.mycart.data.model.CartProduct
import com.buildcart.app.modules.mycart.data.model.CartProductItem
import com.buildcart.app.modules.mycart.data.model.CartRepository
import com.buildcart.app.service.APIManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import retrofit2.Response
import java.util.Locale

class MyCartVM(private val cartRepository: CartRepository) : ViewModel() {

  var navArguments: Bundle? = null

  private val _cartProducts = MutableLiveData<List<CartProductItem>>()

  val cartProducts: LiveData<List<CartProductItem>>
    get() = _cartProducts

  private lateinit var sessionManager: SessionManager

  fun setSessionManager(manager: SessionManager) {
    sessionManager = manager
  }

  // Fetch cart products from the API
  fun getCartProducts() {
    viewModelScope.launch {
      try {
        val token = sessionManager.fetchAuthToken()
        val response = cartRepository.getCartProducts(authorization = "Bearer $token")

        if (response.isSuccessful && response.code() in 200 until 300) {
          _cartProducts.value = response.body()
        } else {
          // Handle unsuccessful response here
          // For example, show an error message
          _cartProducts.value = emptyList() // Set an empty list or handle accordingly
        }

      } catch (e: Exception) {
        // Handle exceptions (e.g., show an error message)
        e.printStackTrace()
        _cartProducts.value = emptyList() // Set an empty list or handle accordingly
      }
    }
  }

  // Add more items to the cart
  fun addMoreItems() {
    // TODO: Implement logic to add more items to the cart
  }

  // Apply coupon
  fun applyCoupon(couponCode: String) {
    // TODO: Implement logic to apply the coupon
  }

  // Proceed to payment
  fun proceedToPayment() {
    // TODO: Implement logic to proceed to payment
  }


  // Get quantity from CartProductItem
  fun getQuantity(cartItem: CartProductItem): Int {
    return cartItem.quantity ?: 0
  }

  // Get product rating from CartProductItem
  fun getProductRating(cartItem: CartProductItem): Float {
    return (cartItem.productRating ?: 0.0f) as Float
  }

  // Get full image URL from APIManager
//  fun getFullImageUrl(productImages: List<String>?): String {
//    val imageUrl = if (productImages != null && productImages.isNotEmpty()) {
//      val imageUrls = productImages.joinToString(",")
//      APIManager.BASE_URL + imageUrls
//    } else {
//      APIManager.BASE_URL
//    }
//    Log.d("getFullImageUrl", imageUrl)
//    return imageUrl
//  }

  fun getFullImageUrl(productImages: List<String>?): String {
    return if (productImages != null && productImages.isNotEmpty()) {
      val imageUrls = productImages.joinToString(",") { it }
      if (imageUrls.startsWith("http")) {
        // Full URL is already provided, no need to append BASE_URL
        Log.d("getFullImageUrl", imageUrls)
        imageUrls
      } else {
        // Construct the full URL using BASE_URL
        Log.d("getFullImageUrl", APIManager.BASE_URL + imageUrls)
        APIManager.BASE_URL + imageUrls
      }
    } else {
      APIManager.BASE_URL // Default URL when no images are available
    }
  }


  fun getFormattedPrice(productResponse: CartProductItem): String {
    return productResponse.sellingPrice?.toString() ?: ""
  }

  // Get product name from CartProductItem
  fun getProductName(productResponse: CartProductItem): String {
    return productResponse.productName ?: ""
  }

  fun getFormattedRating(productResponse: CartProductItem): String {
    return String.format(Locale.getDefault(), "%.1f", productResponse.productRating?.toFloatOrNull() ?: 0.0f)
  }

}
