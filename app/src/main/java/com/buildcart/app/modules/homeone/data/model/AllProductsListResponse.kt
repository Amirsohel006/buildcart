package com.buildcart.app.modules.homeone.data.model

import com.google.gson.annotations.SerializedName

data class AllProductsListResponse( @SerializedName("success"  ) var success  : String?             = null,
                                    @SerializedName("message"  ) var message  : String?             = null,
                                    @SerializedName("response" ) var response : ArrayList<ProductsResponse> = arrayListOf())
data class ProductsResponse (

    @SerializedName("product_id"              ) var productId             : String?        = null,
    @SerializedName("product_galleries"       ) var productGalleries      : String?        = null,
    @SerializedName("product_color_galleries" ) var productColorGalleries : String?        = null,
    @SerializedName("name"                    ) var name                  : String?        = null,
    @SerializedName("selling_price"           ) var sellingPrice          : String?        = null,
    @SerializedName("description"             ) var description           : String?        = null,
    @SerializedName("product_benifits"        ) var productBenifits       : String?        = null,
    @SerializedName("rating"                  ) var rating                : String?        = null,
    @SerializedName("favourate"               ) var favourate             : ArrayList<Int> = arrayListOf()

)
