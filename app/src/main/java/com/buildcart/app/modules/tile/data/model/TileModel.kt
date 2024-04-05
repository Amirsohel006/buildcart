package com.buildcart.app.modules.tile.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class TileModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalProducts: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_total_products)

)
