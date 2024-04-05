package com.buildcart.app.modules.orders.data.model

import com.google.gson.annotations.SerializedName

data class ProductByCategoriesResponse(@SerializedName("success"  ) var success  : String?             = null,
                                       @SerializedName("message"  ) var message  : String?             = null,
                                       @SerializedName("response" ) var response : ArrayList<ProductsByCategoriesResponseData> = arrayListOf())

data class ProductsByCategoriesResponseData(@SerializedName("product_id"              ) var productId             : String?                     = null,
                                            @SerializedName("product_galleries"       ) var productGalleries      : ArrayList<ProductImage> = arrayListOf(),
                                            @SerializedName("product_color_galleries" ) var productColorGalleries : ArrayList<String>           = arrayListOf(),
                                            @SerializedName("name"                    ) var name                  : String?                     = null,
                                            @SerializedName("selling_price"           ) var sellingPrice          : String?                     = null,
                                            @SerializedName("description"             ) var description           : String?                     = null,
                                            @SerializedName("product_benifits"        ) var productBenifits       : String?                     = null,
                                            @SerializedName("rating"                  ) var rating                : String?                     = null,
                                            @SerializedName("favourate"               ) var favourate             : ArrayList<Int>              = arrayListOf())
data class ProductImage (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("image" ) var image : String? = null

)

