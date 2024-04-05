package com.buildcart.app.modules.frame314.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Frame314Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtLoginOrSignup: String? =
      MyApp.getInstance().resources.getString(R.string.msg_login_or_signup)

)
