package com.buildcart.app.modules.home.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class HomeRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDesignTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_design_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_per_piece)

)
