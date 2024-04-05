package com.buildcart.app.modules.mycart.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.buildcart.app.modules.mycart.data.model.CartRepository

class CartViewModelFactory(private val cartRepository: CartRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyCartVM::class.java)) {
            return MyCartVM(cartRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}