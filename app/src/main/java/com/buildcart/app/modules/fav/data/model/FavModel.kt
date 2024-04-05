package com.buildcart.app.modules.fav.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class FavModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFavorites: String? = MyApp.getInstance().resources.getString(R.string.lbl_favorites)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalProducts: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_total_products)

)
