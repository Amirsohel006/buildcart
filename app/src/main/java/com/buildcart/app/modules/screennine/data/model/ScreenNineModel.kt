package com.buildcart.app.modules.screennine.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenNineModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEasytoPayHa: String? = MyApp.getInstance().resources.getString(R.string.msg_easy_to_pay_ha)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSkip: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip)

)
