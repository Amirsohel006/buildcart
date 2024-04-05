package com.buildcart.app.modules.orders.data.model

import com.buildcart.app.modules.mycart.data.model.CartProductItem
import com.buildcart.app.service.APIInterface
import retrofit2.Response

class OrdersRepository(private val apiService: APIInterface) {

    suspend fun getOrdersWithStatus(authorization: String,status:OrderStatusRequest):Response<OrdersResponseData> {
        return apiService.activeOrders(authorization,status)
    }
}