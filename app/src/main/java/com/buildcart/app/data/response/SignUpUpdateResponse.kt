package com.buildcart.app.data.response

data class SignUpUpdateResponse(
    val access_token: String,
    val message: String,
    val refresh_token: String,
    val response: Response,
    val success: String
) {
    data class Response(
        val city: String,
        val email: String,
        val full_name: String,
        val mobile_number: String,
        val photo: String,
        val terms_and_c: Boolean,
        val zipcode: String
    )
}