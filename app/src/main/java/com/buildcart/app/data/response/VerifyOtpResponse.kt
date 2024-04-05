package com.buildcart.app.data.response

import com.google.gson.annotations.SerializedName

data class VerifyOtpResponse(@SerializedName("success"       ) var success      : String? = null,
                             @SerializedName("message"       ) var message      : String? = null,
                             @SerializedName("refresh_token" ) var refreshToken : String? = null,
                             @SerializedName("access_token"  ) var accessToken  : String? = null
)
