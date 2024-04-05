package com.buildcart.app.modules.homeone.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.buildcart.app.modules.homeone.data.ProductsRepository


class ProductDetailsViewModelFactory(private val productsRepository: ProductsRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java)) {
            return ProductDetailsViewModel(productsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}