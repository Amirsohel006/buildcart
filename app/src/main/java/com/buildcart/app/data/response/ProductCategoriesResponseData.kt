package com.buildcart.app.data.response

import com.google.gson.annotations.SerializedName

data class ProductCategoriesResponseData(@SerializedName("success"  ) var success  : String?             = null,
                                         @SerializedName("message"  ) var message  : String?             = null,
                                         @SerializedName("response" ) var response : ArrayList<CategoriesResponse> = arrayListOf())
data class CategoriesResponse (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("name"  ) var name  : String? = null,
    @SerializedName("image" ) var image : String? = null

)