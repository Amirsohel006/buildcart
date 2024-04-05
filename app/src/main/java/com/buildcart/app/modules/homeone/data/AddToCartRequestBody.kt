package com.buildcart.app.modules.homeone.data

import com.google.gson.annotations.SerializedName

data class AddToCartRequestBody(
    @SerializedName("product_id") val productId: String,
    @SerializedName("quantity") val quantity: Int
)

