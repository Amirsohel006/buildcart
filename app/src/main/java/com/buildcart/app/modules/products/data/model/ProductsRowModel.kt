package com.buildcart.app.modules.products.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ProductsRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDesignTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_design_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_per_piece)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupEleven: String? = MyApp.getInstance().resources.getString(R.string.lbl_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQty: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty)

)
