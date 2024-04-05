package com.buildcart.app.modules.screenseven.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenSevenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBuildYourDrea: String? =
      MyApp.getInstance().resources.getString(R.string.msg_build_your_drea)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSkip: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip)

)
