package com.buildcart.app.modules.homeone.data.model

import com.google.gson.annotations.SerializedName

data class ProductDetailsDataResponse( @SerializedName("product_id") var productId: String? = null,
                                       @SerializedName("name") var name: String? = null,
                                       @SerializedName("selling_price") var sellingPrice: String? = null,
                                       @SerializedName("description") var description: String? = null,
                                       @SerializedName("product_galleries") var productGalleries: ArrayList<ProductImageGalleries> = arrayListOf(),
                                       @SerializedName("product_color_galleries") var productColorGalleries: ArrayList<String> = arrayListOf(),
                                       @SerializedName("product_benefits") var productBenefits: String? = null,
                                       @SerializedName("rating") var rating: String? = null)
data class ProductImageGalleries (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("image" ) var image : String? = null

)



data class ProductdescriptionResponse(
    @SerializedName("success"  ) var success  : String?             = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : ArrayList<ResponseForProducts> = arrayListOf()
)


data class ProductGalleriesByID (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("image" ) var image : String? = null

)



data class ResponseForProducts (

    @SerializedName("product_id"              ) var productId             : String?                     = null,
    @SerializedName("name"                    ) var name                  : String?                     = null,
    @SerializedName("selling_price"           ) var sellingPrice          : String?                     = null,
    @SerializedName("description"             ) var description           : String?                     = null,
    @SerializedName("product_galleries"       ) var productGalleries      : ArrayList<ProductGalleriesByID> = arrayListOf(),
    @SerializedName("product_color_galleries" ) var productColorGalleries : ArrayList<String>           = arrayListOf(),
    @SerializedName("product_benifits"        ) var productBenifits       : String?                     = null,
    @SerializedName("rating"                  ) var rating                : String?                     = null

)