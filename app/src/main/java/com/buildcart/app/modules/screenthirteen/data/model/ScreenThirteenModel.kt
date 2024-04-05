package com.buildcart.app.modules.screenthirteen.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ScreenThirteenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEasytoPayHa: String? = MyApp.getInstance().resources.getString(R.string.msg_easy_to_pay_ha)

)
