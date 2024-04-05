package com.buildcart.app.modules.product.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Listrectangle105OneRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDesignTilesOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_design_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_per_piece)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwenty: String? = MyApp.getInstance().resources.getString(R.string.lbl_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQty: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtComponentOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_to_cart)

)
