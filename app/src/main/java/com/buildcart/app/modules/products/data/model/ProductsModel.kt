package com.buildcart.app.modules.products.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ProductsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtProducts: String? = MyApp.getInstance().resources.getString(R.string.lbl_products)

)
