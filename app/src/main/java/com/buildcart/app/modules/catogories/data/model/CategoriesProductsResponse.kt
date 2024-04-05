package com.buildcart.app.modules.catogories.data.model

import com.google.gson.annotations.SerializedName

data class CategoriesProductsResponse(@SerializedName("success"  ) var success  : String?             = null,
                                      @SerializedName("message"  ) var message  : String?             = null,
                                      @SerializedName("response" ) var response : ArrayList<CategoriesProductsResponseData> = arrayListOf())
data class ProductGalleries (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("image" ) var image : String? = null

)

data class CategoriesProductsResponseData (

    @SerializedName("product_id"              ) var productId             : String?                     = null,
    @SerializedName("name"                    ) var name                  : String?                     = null,
    @SerializedName("selling_price"           ) var sellingPrice          : String?                     = null,
    @SerializedName("description"             ) var description           : String?                     = null,
    @SerializedName("product_galleries"       ) var productGalleries      : ArrayList<ProductGalleries> = arrayListOf(),
    @SerializedName("product_color_galleries" ) var productColorGalleries : ArrayList<String>           = arrayListOf(),
    @SerializedName("product_benifits"        ) var productBenifits       : String?                     = null,
    @SerializedName("rating"                  ) var rating                : String?                     = null

)
