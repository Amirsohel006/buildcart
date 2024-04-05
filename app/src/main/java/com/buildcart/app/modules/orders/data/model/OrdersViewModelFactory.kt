package com.buildcart.app.modules.orders.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.buildcart.app.modules.mycart.data.viewmodel.MyCartVM
import com.buildcart.app.modules.orders.data.viewmodel.OrdersSectionVM

class OrdersViewModelFactory(private val ordersRepository: OrdersRepository): ViewModelProvider.Factory
{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrdersSectionVM::class.java)) {
            return OrdersSectionVM(ordersRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}