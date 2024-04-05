package com.buildcart.app.modules.ordersfive.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class OrdersFiveRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtExpectedDelive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_expected_delive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt27MayWed: String? = MyApp.getInstance().resources.getString(R.string.lbl_27_may_wed)

)
