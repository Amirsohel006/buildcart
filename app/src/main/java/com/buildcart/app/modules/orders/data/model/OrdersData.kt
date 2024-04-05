package com.buildcart.app.modules.orders.data.model

import com.google.gson.annotations.SerializedName

data class OrdersResponseData(
    @SerializedName("success") var success: String? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("response") var response: List<OrdersData>? = null
)

data class OrdersData(
    @SerializedName("order") var order: String? = null,
    @SerializedName("order_placed_date") var orderPlacedDate: String? = null,
    @SerializedName("coupon_code") var couponCode: String? = null,
    @SerializedName("is_paid") var isPaid: Boolean = false,
    @SerializedName("mode_of_payment") var modeOfPayment: String? = null,
    @SerializedName("quantity") var quantity: Int = 0,
    @SerializedName("user") var user: Int = 0,
    @SerializedName("product") var product: Product? = null,
    @SerializedName("order_status") var orderStatus: String? = null,
    @SerializedName("order_address") var orderAddress: Int = 0
)

data class Product(
    @SerializedName("product_id") var productId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("categories") var categories: List<Category>? = null,
    @SerializedName("favourate") var favourate: List<Favourate>? = null,
    @SerializedName("total_quantity") var totalQuantity: Int = 0,
    @SerializedName("description") var description: String? = null,
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("selling_price") var sellingPrice: String? = null,
    @SerializedName("product_benifits") var productBenifits: String? = null,
    @SerializedName("product_galleries") var productGalleries: List<ProductGallery>? = null,
    @SerializedName("product_color_galleries") var productColorGalleries: List<ProductColorGallery>? = null,
    @SerializedName("is_active") var isActive: Boolean = false
)

data class Category(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("is_active") var isActive: Boolean = false,
    @SerializedName("is_featured") var isFeatured: Boolean = false
)

data class Favourate(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("last_login") var lastLogin: String? = null,
    // ... other fields
)

data class ProductGallery(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("is_featured") var isFeatured: Boolean = false,
    @SerializedName("product") var product: String? = null
)

data class ProductColorGallery(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("color_name") var colorName: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("is_featured") var isFeatured: Boolean = false,
    @SerializedName("product") var product: String? = null
)
