package com.buildcart.app.modules.frame308.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Frame308Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderPlacedSu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_order_placed_su)

)
