package com.buildcart.app.data.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(@SerializedName("success"       ) var success      : String? = null,
                          @SerializedName("refresh_token" ) var refreshToken : String? = null,
                          @SerializedName("access_token"  ) var accessToken  : String? = null,
                          @SerializedName("mobile_number" ) var mobileNumber : String? = null)
