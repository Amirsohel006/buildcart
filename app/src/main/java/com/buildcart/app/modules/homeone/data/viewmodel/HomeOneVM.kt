package com.buildcart.app.modules.homeone.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.modules.homeone.data.model.HomeOneRowModel
import com.buildcart.app.modules.homeone.data.model.ProductsResponse
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomeOneVM : ViewModel(), KoinComponent {

  val homeOneList: MutableLiveData<MutableList<HomeOneRowModel>> = MutableLiveData(mutableListOf())

  private val productsRepository: ProductsRepository by inject()

  private val _allProductsList = MutableLiveData<List<ProductsResponse>>()


  fun getFormattedPrice(productsResponse: ProductsResponse?): String {
    return productsResponse?.sellingPrice ?: ""
  }

  fun onPlusClick(productsResponse: ProductsResponse) {
    // Find the corresponding HomeOneRowModel in homeOneList and update its quantity
    val homeOneRowModel = homeOneList.value?.find { it.productId == productsResponse.productId }
    homeOneRowModel?.incrementQuantity()
    updateHomeOneList()
  }

  fun onMinusClick(productsResponse: ProductsResponse) {
    // Find the corresponding HomeOneRowModel in homeOneList and update its quantity
    val homeOneRowModel = homeOneList.value?.find { it.productId == productsResponse.productId }
    homeOneRowModel?.decrementQuantity()
    updateHomeOneList()
  }

  fun onAddToCartClick(homeOneRowModel: ProductsResponse) {
    // Placeholder for your add to cart logic
    // You should implement the actual logic to add the product to the cart
    // You can access the necessary details from homeOneRowModel
  }

  private fun updateHomeOneList() {
    homeOneList.value = homeOneList.value?.toMutableList()
  }
}
