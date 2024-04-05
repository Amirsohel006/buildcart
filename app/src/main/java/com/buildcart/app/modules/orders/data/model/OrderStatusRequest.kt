package com.buildcart.app.modules.orders.data.model

import com.google.gson.annotations.SerializedName

data class OrderStatusRequest(
@SerializedName("status") val status: String
)
