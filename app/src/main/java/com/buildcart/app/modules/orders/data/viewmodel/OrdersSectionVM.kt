package com.buildcart.app.modules.orders.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.mycart.data.model.CartRepository
import com.buildcart.app.modules.orders.data.model.OrderStatusRequest
import com.buildcart.app.modules.orders.data.model.OrdersData
import com.buildcart.app.modules.orders.data.model.OrdersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class Order(
    val imageUrl: String,
    val productName: String,
    val productColor: String,
    val quantity: Int,
    val amount: String
)

// Adjust the type to reflect the structure of your API response
data class OrdersResponse(
    val success: String,
    val message: String,
    val response: List<OrdersData>
)
class OrdersSectionVM(private val ordersRepository: OrdersRepository) : ViewModel() {

    private val _activeOrders = MutableLiveData<OrdersResponse>()
    private val _completedOrders = MutableLiveData<OrdersResponse>()
    private val _cancelledOrders = MutableLiveData<OrdersResponse>()

    val activeOrders: LiveData<OrdersResponse> get() = _activeOrders
    val completedOrders: LiveData<OrdersResponse> get() = _completedOrders
    val cancelledOrders: LiveData<OrdersResponse> get() = _cancelledOrders



    private lateinit var sessionManager: SessionManager

    fun setSessionManager(manager: SessionManager) {
        sessionManager = manager
    }


    fun getCancelledOrders() {
        fetchOrdersByStatus("cancelled", _cancelledOrders)
    }

    fun getActiveOrders() {
        fetchOrdersByStatus("pending", _activeOrders)
    }

    fun getCompletedOrders() {
        fetchOrdersByStatus("delivered", _completedOrders)
    }






private fun fetchOrdersByStatus(
    status: String,
    liveData: MutableLiveData<OrdersResponse>
) {
    viewModelScope.launch {
        try {
            val statusRequest = OrderStatusRequest(status)

            val token = sessionManager.fetchAuthToken()
            val authorization = "Bearer $token"
            val response = ordersRepository.getOrdersWithStatus(authorization, statusRequest)

            if (response.isSuccessful) {
                val ordersResponse = OrdersResponse(
                    success = response.body()?.success.orEmpty(),
                    message = response.body()?.message.orEmpty(),
                    response = response.body()?.response ?: emptyList()
                )
                liveData.postValue(ordersResponse)
            } else {
                    // Handle the case when the API response body is null


                }

        } catch (e: Exception) {
            e.printStackTrace()
            // Handle network or other exceptions if needed
        }
    }
}

    init {
        // Initialize your order data here (replace with your actual data source)
        // For example:
        val sampleActiveOrders = listOf(
            Order("active_image_url", "Product 1", "Red", 2, "30.0"),
            Order("active_image_url", "Product 2", "Blue", 1, "15.0")
        )

        val sampleCompletedOrders = listOf(
            Order("completed_image_url", "Product 3", "Green", 3, "45.0"),
            Order("completed_image_url", "Product 4", "Yellow", 1, "20.0")
        )

        val sampleCancelledOrders = listOf(
            Order("cancelled_image_url", "Product 5", "Black", 1, "15.0"),
            Order("cancelled_image_url", "Product 6", "White", 2, "30.0")
        )

    }

}
