package com.buildcart.app.modules.signuo.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPaypal: String? = MyApp.getInstance().resources.getString(R.string.lbl_paypal)

)
