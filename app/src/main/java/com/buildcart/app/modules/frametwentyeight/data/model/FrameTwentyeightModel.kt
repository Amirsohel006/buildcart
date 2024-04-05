package com.buildcart.app.modules.frametwentyeight.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class FrameTwentyeightModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderCancelled: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_order_cancelled)

)
