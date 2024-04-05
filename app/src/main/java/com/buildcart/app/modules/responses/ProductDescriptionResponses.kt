package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

data class ProductDescriptionResponses(
    @SerializedName("success"  ) var success  : String?   = null,
    @SerializedName("message"  ) var message  : String?   = null,
    @SerializedName("response" ) var response : DescriptionResponse? = DescriptionResponse()

)


data class DescriptionResponse (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null,
    @SerializedName("quantity"   ) var quantity  : Int?    = null,
    @SerializedName("user"       ) var user      : Int?    = null,
    @SerializedName("product"    ) var product   : String? = null

)