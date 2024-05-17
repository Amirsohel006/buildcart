package com.buildcart.app.data.response

data class BuyAllProductsRequest(
    val shipping_address_id: String,
    val mode_of_payment: String,
    //val coupon_code: String
)
