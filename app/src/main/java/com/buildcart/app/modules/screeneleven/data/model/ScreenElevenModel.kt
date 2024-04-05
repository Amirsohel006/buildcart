package com.buildcart.app.modules.screeneleven.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenElevenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtBuildYourDrea: String? =
      MyApp.getInstance().resources.getString(R.string.msg_build_your_drea)

)
