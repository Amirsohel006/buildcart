package com.buildcart.app.data

data class ProductDataResponse(
val success: String,
val message: String,
val response: List<ProductResponseItem>
)

data class ProductResponseItem(
    val product_id: String,
    val name: String,
    val selling_price: String,
    val description: String,
    val rating: Float,
    //val image: String,
    val product_galleries: List<ProductGalleryItem>,
    var initialQuantity: Int = 0,
    var isAddedToCart: Boolean = false,
    var addToCartButtonText: String = "Add to Cart",
    val position: Int = -1

    // ... other properties
)
data class ProductGalleryItem(
    val id: Int,
    val image: String
)