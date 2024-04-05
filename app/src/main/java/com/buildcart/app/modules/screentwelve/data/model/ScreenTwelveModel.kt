package com.buildcart.app.modules.screentwelve.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenTwelveModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPurchaseHighQ: String? =
      MyApp.getInstance().resources.getString(R.string.msg_purchase_high_q)

)
