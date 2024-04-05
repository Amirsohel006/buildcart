package com.buildcart.app.modules.homeone.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.buildcart.app.data.ProductGalleryItem
import com.buildcart.app.data.ProductResponseItem
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.CategoriesResponse
import com.buildcart.app.modules.catogories.data.model.CategoryIdRequest
import com.buildcart.app.modules.homeone.data.AddToCartRequestBody
import com.buildcart.app.modules.homeone.data.CategoriesRepository
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.service.APIManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class HomeOneViewModel(
    private val productsRepository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository
) : ViewModel() {
    private val _productList = MutableLiveData<List<ProductResponseItem>>()
    val productListLiveData: LiveData<List<ProductResponseItem>> get() = _productList


    private val _categoriesProductList=MutableLiveData<List<ProductResponseItem>>()





    private val _categoriesProductListLiveData:LiveData<List<ProductResponseItem>> get()=_categoriesProductList
    private val _categoryList = MutableLiveData<List<CategoriesResponse>>()
    val categoryList: LiveData<List<CategoriesResponse>> get() = _categoryList

    private val _isAddedToCart = MutableLiveData<Boolean>()
    val isAddedToCart: LiveData<Boolean> get() = _isAddedToCart

    private val _selectedProduct = MutableLiveData<ProductResponseItem>()
    val selectedProduct: LiveData<ProductResponseItem> get() = _selectedProduct

    private val _addToCartButtonText = MutableLiveData<Pair<Int, String>>()
    val addToCartButtonText: LiveData<Pair<Int, String>> get() = _addToCartButtonText

    private val _navigateToCartFragment = MutableLiveData<Boolean>()
    val navigateToCartFragment: LiveData<Boolean> get() = _navigateToCartFragment


    private lateinit var sessionManager: SessionManager

    fun setSelectedProduct(product: ProductResponseItem) {
        _selectedProduct.value = product
    }

    fun setSessionManager(manager: SessionManager) {
        sessionManager = manager
    }
    fun fetchProductList(useDummyData: Boolean = false) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = productsRepository.getAllProducts()
                _productList.value = result.response

            } catch (e: Exception) {
                _productList.value = emptyList()
            }
        }
    }


    fun getProductList(): LiveData<List<ProductResponseItem>> {
        return productListLiveData
    }

    fun getCategoriesList(): LiveData<List<CategoriesResponse>> {
        return categoryList
    }

    fun getProductByCategories():LiveData<List<ProductResponseItem>>{
        return _categoriesProductListLiveData
    }
    fun onAddToCartClick(productResponse: ProductResponseItem,position: Int) {
        viewModelScope.launch {
            try {
                val token = sessionManager.fetchAuthToken()
                if (!token.isNullOrBlank()) {
                    val addToCartRequestBody = AddToCartRequestBody(
                        productId = productResponse.product_id,
                        quantity = productResponse.initialQuantity
                    )
                    val response = productsRepository.addProductToCart(
                        authorization = "Bearer $token",
                        addToCartRequestBody = addToCartRequestBody
                    )

                    if (response.isSuccessful) {
                        productResponse.isAddedToCart = true
                        productResponse.addToCartButtonText = "Go to Cart"
                        _addToCartButtonText.value = Pair(position, "Go to Cart")
                        _isAddedToCart.value = true // Notify observers about the change
                        Log.d("HomeOneViewModel", "Button text changed for position $position: Go to Cart")
                        _addToCartButtonText.postValue(Pair(position, "Go to Cart"))
                        Log.d("HomeOneViewModel", "Added to Cart: ${productResponse.product_id}")

                    } else {
                        productResponse.isAddedToCart = false
                        _addToCartButtonText.value = Pair(position, "Add to Cart")
                        productResponse.addToCartButtonText = "Add to Cart"
                        _isAddedToCart.value = false // Notify observers about the change
                        Log.e("HomeOneViewModel", "API Error: ${response.errorBody()}")
                    }
                } else {
                    productResponse.isAddedToCart = false
                    productResponse.addToCartButtonText = "Add to Cart"
                    _addToCartButtonText.value = Pair(position, "Add to Cart")
                    _isAddedToCart.value = false // Notify observers about the change
                    Log.e("HomeOneViewModel", "Authentication token is null or blank")

                }
            } catch (e: Exception) {
                productResponse.isAddedToCart = false
                productResponse.addToCartButtonText = "Add to Cart"
                _addToCartButtonText.value = Pair(position, "Add to Cart")
                Log.e("HomeOneViewModel", "Exception during API call: ${e.message}")
                _isAddedToCart.value = false // Notify observers about the change
                e.printStackTrace()
            }
        }
    }


    fun fetchProductByCategoryId(productId: String) {
        viewModelScope.launch {
            try {
                val token = sessionManager.fetchAuthToken()
                val authorization="Bearer $token"

                val categoryIdRequest = CategoryIdRequest(category_id = productId)
                // Perform API call to get product details
                val response = productsRepository.getProductByCategories(authorization,categoryIdRequest)

              //  if (response.isSuccessful) {
                    _categoriesProductList.value = response.response
               // } else {
                    // Handle error case
                    // You may want to define a separate LiveData for error handling
               // }

            } catch (e: Exception) {
                e.printStackTrace()
                // Handle exception
                // You may want to define a separate LiveData for error handling
            }
        }
    }
    fun onGoToCartClick(productResponse: ProductResponseItem) {
        Log.d("HomeOneViewModel", "Navigate to Cart for product: ${productResponse.product_id}")

        _navigateToCartFragment.value = true
    }

    fun onNavigationToCartComplete() {
        _navigateToCartFragment.value = false
    }
    fun fetchCategoryList() {
        viewModelScope.launch {
            try {
                val response = categoriesRepository.getCategories()
                if (response.isSuccessful) {
                    _categoryList.value = response.body()?.response
                } else {
                    Log.e("HomeOneViewModel", "API Error: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onPlusClick(productResponse: ProductResponseItem) {
        val updatedList = _productList.value?.toMutableList()
        val updatedProduct = updatedList?.find { it.product_id == productResponse.product_id }
        updatedProduct?.let {
            it.initialQuantity++
        }
        _productList.value = updatedList ?: emptyList()
    }

    fun onMinusClick(productResponse: ProductResponseItem) {
        val updatedList = _productList.value?.toMutableList()
        val updatedProduct = updatedList?.find { it.product_id == productResponse.product_id }
        updatedProduct?.let {
            if (it.initialQuantity > 0) {
                it.initialQuantity--
            }
        }
        _productList.value = updatedList ?: emptyList()
    }

    fun getFormattedPrice(productResponse: ProductResponseItem): String {
        return productResponse.selling_price ?: ""
    }

    fun getProductName(productResponse: ProductResponseItem): String {
        return productResponse.name
    }

    fun getFormattedRating(productResponse: ProductResponseItem): String {
        return String.format(Locale.getDefault(), "Rating: %.1f", productResponse.rating)
    }

    fun getFullImageUrl(productGalleries: List<ProductGalleryItem>): String {
        val imageUrls = productGalleries.joinToString(",") { it.image }
        return APIManager.BASE_URL + imageUrls
    }

    fun getCategoriesImageUrl(categoriesResponse: CategoriesResponse): String {
        return APIManager.BASE_URL + categoriesResponse.image
    }
}
