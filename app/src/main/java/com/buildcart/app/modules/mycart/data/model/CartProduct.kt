package com.buildcart.app.modules.mycart.data.model


import com.google.gson.annotations.SerializedName

data class CartProduct(
    @SerializedName("success"  ) var success  : String?             = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : ArrayList<CartProductItem> = arrayListOf()
)



data class CartProductItem(
    @SerializedName("id"             ) var id            : Int?                     = null,
    @SerializedName("product_name"   ) var productName   : String?                  = null,
    @SerializedName("product_rating" ) var productRating : String?                  = null,
    @SerializedName("product_images" ) var productImages : ArrayList<ProductImages> = arrayListOf(),
    @SerializedName("quantity"       ) var quantity      : Int?                     = null,
    @SerializedName("selling_price"  ) var sellingPrice  : Int?                     = null,
    @SerializedName("total_price"    ) var totalPrice    : Int?                     = null
)

data class ProductImages(
    @SerializedName("img1" ) var img1 : String? = null,
    @SerializedName("img2")  var img2: String?=null
)
