package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

data class PrivacyPolicy(
    @SerializedName("success"  ) var success  : String?             = null,
    @SerializedName("response" ) var response : ArrayList<PrivacyResponse> = arrayListOf()
)

data class PrivacyResponse (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("created_at"  ) var createdAt   : String? = null,
    @SerializedName("updated_at"  ) var updatedAt   : String? = null,
    @SerializedName("title"       ) var title       : String? = null,
    @SerializedName("description" ) var description : String? = null

)