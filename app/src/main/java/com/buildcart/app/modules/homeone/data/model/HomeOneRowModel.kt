package com.buildcart.app.modules.homeone.data.model

import android.content.Context
import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp

data class HomeOneRowModel(
  var txtDesignTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_design_tiles),
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_per_piece),
  var txtGroupSixtyTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_00),
  var txtQty: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty),
  var quantity: Int = 0,
  // Add static data properties with default values
  var productName: String = "Product",
  var description: String = "Description",
  var imageResId: Int = R.drawable.category_2,
  var price: Double = 0.0,
  var productId: String = ""
) {

  fun getFormattedPrice(): String {
    // Format the price as needed, e.g., "$10.99"
    return String.format("$%.2f", price)
  }

  // Method to increase the quantity
  fun incrementQuantity() {
    quantity++
  }

  // Method to decrease the quantity, ensuring it doesn't go below zero
  fun decrementQuantity() {
    if (quantity > 0) {
      quantity--
    }
  }

  // If you want to use resources outside of the constructor, you can pass the context
  fun updateTexts(context: Context) {
    txtDesignTiles = context.getString(R.string.lbl_design_tiles)
    txtPrice = context.getString(R.string.lbl_17_per_piece)
    txtGroupSixtyTwo = context.getString(R.string.lbl_00)
    txtQty = context.getString(R.string.lbl_qty)
  }
}
