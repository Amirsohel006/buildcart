package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

data class CompltedOrderResponse(

    @SerializedName("success"  ) var success  : String?             = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : ArrayList<CompleteResponse> = arrayListOf()

)


data class CompleteProductGalleries (

    @SerializedName("id"          ) var id         : Int?     = null,
    @SerializedName("created_at"  ) var createdAt  : String?  = null,
    @SerializedName("updated_at"  ) var updatedAt  : String?  = null,
    @SerializedName("image"       ) var image      : String?  = null,
    @SerializedName("is_featured" ) var isFeatured : Boolean? = null,
    @SerializedName("product"     ) var product    : String?  = null

)

data class CompleteProduct (

    @SerializedName("product_id"              ) var productId             : String?                     = null,
    @SerializedName("name"                    ) var name                  : String?                     = null,
    @SerializedName("categories"              ) var categories            : ArrayList<String>           = arrayListOf(),
    @SerializedName("favourate"               ) var favourate             : ArrayList<String>           = arrayListOf(),
    @SerializedName("total_quantity"          ) var totalQuantity         : Int?                        = null,
    @SerializedName("description"             ) var description           : String?                     = null,
    @SerializedName("rating"                  ) var rating                : String?                     = null,
    @SerializedName("selling_price"           ) var sellingPrice          : String?                     = null,
    @SerializedName("product_benifits"        ) var productBenifits       : String?                     = null,
    @SerializedName("product_galleries"       ) var productGalleries      : ArrayList<CompleteProductGalleries> = arrayListOf(),
    @SerializedName("product_color_galleries" ) var productColorGalleries : ArrayList<String>           = arrayListOf(),
    @SerializedName("is_active"               ) var isActive              : Boolean?                    = null

)


data class CompleteResponse (

    @SerializedName("order"             ) var order           : String?  = null,
    @SerializedName("order_placed_date" ) var orderPlacedDate : String?  = null,
    @SerializedName("coupon_code"       ) var couponCode      : String?  = null,
    @SerializedName("is_paid"           ) var isPaid          : Boolean? = null,
    @SerializedName("mode_of_payment"   ) var modeOfPayment   : String?  = null,
    @SerializedName("quantity"          ) var quantity        : Int?     = null,
    @SerializedName("user"              ) var user            : Int?     = null,
    @SerializedName("product"           ) var product         : CompleteProduct? = CompleteProduct(),
    @SerializedName("order_status"      ) var orderStatus     : String?  = null,
    @SerializedName("order_address"     ) var orderAddress    : Int?     = null

)