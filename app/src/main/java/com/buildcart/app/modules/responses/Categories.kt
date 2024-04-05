package com.buildcart.app.modules.responses

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("success"  ) var success  : String?             = null,
    @SerializedName("message"  ) var message  : String?             = null,
    @SerializedName("response" ) var response : ArrayList<Response> = arrayListOf()
)


data class Categories (

    @SerializedName("id"          ) var id         : Int?     = null,
    @SerializedName("created_at"  ) var createdAt  : String?  = null,
    @SerializedName("updated_at"  ) var updatedAt  : String?  = null,
    @SerializedName("name"        ) var name       : String?  = null,
    @SerializedName("image"       ) var image      : String?  = null,
    @SerializedName("is_active"   ) var isActive   : Boolean? = null,
    @SerializedName("is_featured" ) var isFeatured : Boolean? = null

)

data class Favourate (

    @SerializedName("id"               ) var id              : Int?              = null,
    @SerializedName("last_login"       ) var lastLogin       : String?           = null,
    @SerializedName("is_superuser"     ) var isSuperuser     : Boolean?          = null,
    @SerializedName("username"         ) var username        : String?           = null,
    @SerializedName("email"            ) var email           : String?           = null,
    @SerializedName("password"         ) var password        : String?           = null,
    @SerializedName("otp"              ) var otp             : String?           = null,
    @SerializedName("is_customer"      ) var isCustomer      : Boolean?          = null,
    @SerializedName("is_block"         ) var isBlock         : Boolean?          = null,
    @SerializedName("is_admin"         ) var isAdmin         : Boolean?          = null,
    @SerializedName("is_verified"      ) var isVerified      : Boolean?          = null,
    @SerializedName("is_superadmin"    ) var isSuperadmin    : Boolean?          = null,
    @SerializedName("is_staff"         ) var isStaff         : Boolean?          = null,
    @SerializedName("groups"           ) var groups          : ArrayList<String> = arrayListOf(),
    @SerializedName("user_permissions" ) var userPermissions : ArrayList<String> = arrayListOf()

)


data class ProductGalleries (

    @SerializedName("id"          ) var id         : Int?     = null,
    @SerializedName("created_at"  ) var createdAt  : String?  = null,
    @SerializedName("updated_at"  ) var updatedAt  : String?  = null,
    @SerializedName("image"       ) var image      : String?  = null,
    @SerializedName("is_featured" ) var isFeatured : Boolean? = null,
    @SerializedName("product"     ) var product    : String?  = null

)

data class ProductColorGalleries (

    @SerializedName("id"          ) var id         : Int?     = null,
    @SerializedName("created_at"  ) var createdAt  : String?  = null,
    @SerializedName("updated_at"  ) var updatedAt  : String?  = null,
    @SerializedName("color_name"  ) var colorName  : String?  = null,
    @SerializedName("image"       ) var image      : String?  = null,
    @SerializedName("is_featured" ) var isFeatured : Boolean? = null,
    @SerializedName("product"     ) var product    : String?  = null

)


data class Product (

    @SerializedName("product_id"              ) var productId             : String?                          = null,
    @SerializedName("name"                    ) var name                  : String?                          = null,
    @SerializedName("categories"              ) var categories            : ArrayList<Categories>            = arrayListOf(),
    @SerializedName("favourate"               ) var favourate             : ArrayList<Favourate>             = arrayListOf(),
    @SerializedName("total_quantity"          ) var totalQuantity         : Int?                             = null,
    @SerializedName("description"             ) var description           : String?                          = null,
    @SerializedName("rating"                  ) var rating                : String?                          = null,
    @SerializedName("selling_price"           ) var sellingPrice          : String?                          = null,
    @SerializedName("product_benifits"        ) var productBenifits       : String?                          = null,
    @SerializedName("product_galleries"       ) var productGalleries      : ArrayList<ProductGalleries>      = arrayListOf(),
    @SerializedName("product_color_galleries" ) var productColorGalleries : ArrayList<ProductColorGalleries> = arrayListOf(),
    @SerializedName("is_active"               ) var isActive              : Boolean?                         = null

)


data class Response (

    @SerializedName("order"             ) var order           : String?  = null,
    @SerializedName("order_placed_date" ) var orderPlacedDate : String?  = null,
    @SerializedName("coupon_code"       ) var couponCode      : String?  = null,
    @SerializedName("is_paid"           ) var isPaid          : Boolean? = null,
    @SerializedName("mode_of_payment"   ) var modeOfPayment   : String?  = null,
    @SerializedName("quantity"          ) var quantity        : Int?     = null,
    @SerializedName("user"              ) var user            : Int?     = null,
    @SerializedName("product"           ) var product         : Product? = Product(),
    @SerializedName("order_status"      ) var orderStatus     : String?  = null,
    @SerializedName("order_address"     ) var orderAddress    : Int?     = null

)

