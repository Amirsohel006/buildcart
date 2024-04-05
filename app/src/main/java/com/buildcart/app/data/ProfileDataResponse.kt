package com.buildcart.app.data

import com.google.gson.annotations.SerializedName

data class ProfileDataResponse(  @SerializedName("success"  ) var success  : String?   = null,
                                 @SerializedName("message"  ) var message  : String?   = null,
                                 @SerializedName("response" ) var response : Response? = Response()
)
data class Response (

    @SerializedName("id"              ) var id             : Int?     = null,
    @SerializedName("created_at"      ) var createdAt      : String?  = null,
    @SerializedName("updated_at"      ) var updatedAt      : String?  = null,
    @SerializedName("full_name"       ) var fullName       : String?  = null,
    @SerializedName("mobile_number"   ) var mobileNumber   : String?  = null,
    @SerializedName("referral_code"   ) var referralCode   : String?  = null,
    @SerializedName("referral_counts" ) var referralCounts : Int?     = null,
    @SerializedName("city"            ) var city           : String?  = null,
    @SerializedName("state"           ) var state          : String?  = null,
    @SerializedName("zipcode"         ) var zipcode        : String?  = null,
    @SerializedName("photo"           ) var photo          : String?  = null,
    @SerializedName("terms_and_c"     ) var termsAndC      : Boolean? = null,
    @SerializedName("fcm_token"       ) var fcmToken       : String?  = null,
    @SerializedName("email"           ) var email          : String?  = null

)