package com.buildcart.app.data.response

import com.google.gson.annotations.SerializedName

data class RequestSignUpResponse(@SerializedName("success"       ) var success      : String? = null,
                                 @SerializedName("message"       ) var message      : String? = null,
                                 @SerializedName("mobile_number" ) var mobileNumber : String? = null,
                                 @SerializedName("otp"           ) var otp          : Int?    = null)
