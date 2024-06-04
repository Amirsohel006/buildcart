package com.buildcart.app.modules

data class AddressRequest(
    val full_name: String,
    val mobile_number: String,
    val place: String,
    val house_no: String,
    val city: String,
    val state: String,
    val pincode: String,
    val landmark: String,
    val house_name: String,
    val area: String,
    val street: String,
    val set_as_default: String
)
