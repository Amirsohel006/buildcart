package com.buildcart.app.modules.product.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Listrectangle105FourRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDesignTilesFour: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_design_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_per_piece)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwentyThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQtyThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtComponentOneThree: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_add_to_cart)

)
