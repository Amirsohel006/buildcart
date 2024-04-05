package com.buildcart.app.modules.homeone.data.model

import com.google.gson.annotations.SerializedName

data class AllProductListResponse(@SerializedName("success"  ) var success  : String?             = null,
                                  @SerializedName("message"  ) var message  : String?             = null,
                                  @SerializedName("response" ) var response : ArrayList<ProductResponseData> = arrayListOf())
data class ProductGalleries (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("image" ) var image : String? = null

)

data class ProductColorGalleries (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("image"      ) var image     : String? = null,
    @SerializedName("color_name" ) var colorName : String? = null

)

data class ProductResponseData (

    @SerializedName("product_id"              ) var productId             : String?                          = null,
    @SerializedName("name"                    ) var name                  : String?                          = null,
    @SerializedName("selling_price"           ) var sellingPrice          : String?                          = null,
    @SerializedName("description"             ) var description           : String?                          = null,
    @SerializedName("product_galleries"       ) var productGalleries      : ArrayList<ProductGalleries>      = arrayListOf(),
    @SerializedName("product_color_galleries" ) var productColorGalleries : ArrayList<ProductColorGalleries> = arrayListOf(),
    @SerializedName("product_benifits"        ) var productBenifits       : String?                          = null,
    @SerializedName("rating"                  ) var rating                : String?                          = null

)
{
    var quantity: Int = 0
}