package com.buildcart.app.data.response

import com.google.gson.annotations.SerializedName

data class FavrioteResponse(
    @SerializedName("success"  ) var success  : String?             = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : ArrayList<FavrioteResponse1> = arrayListOf()
)



data class FavrioteResponse1 (

    @SerializedName("product_id"        ) var productId       : String?           = null,
    @SerializedName("created_at"        ) var createdAt       : String?           = null,
    @SerializedName("updated_at"        ) var updatedAt       : String?           = null,
    @SerializedName("name"              ) var name            : String?           = null,
    @SerializedName("total_quantity"    ) var totalQuantity   : Int?              = null,
    @SerializedName("description"       ) var description     : String?           = null,
    @SerializedName("rating"            ) var rating          : String?           = null,
    @SerializedName("selling_price"     ) var sellingPrice    : String?           = null,
    @SerializedName("product_benifits"  ) var productBenifits : String?           = null,
    @SerializedName("has_color_varient" ) var hasColorVarient : Boolean?          = null,
    @SerializedName("is_active"         ) var isActive        : Boolean?          = null,
    @SerializedName("is_popular"        ) var isPopular       : Boolean?          = null,
    @SerializedName("categories"        ) var categories      : ArrayList<String> = arrayListOf(),
    @SerializedName("favourate"         ) var favourate       : String?           = null

)
