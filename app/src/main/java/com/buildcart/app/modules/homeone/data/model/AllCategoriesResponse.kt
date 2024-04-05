package com.buildcart.app.modules.homeone.data.model

import com.google.gson.annotations.SerializedName

data class AllCategoriesResponse(@SerializedName("success"  ) var success  : String?             = null,
                                 @SerializedName("message"  ) var message  : String?             = null,
                                 @SerializedName("response" ) var response : ArrayList<Response> = arrayListOf())
data class Response (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("name"  ) var name  : String? = null,
    @SerializedName("image" ) var image : String? = null

)
