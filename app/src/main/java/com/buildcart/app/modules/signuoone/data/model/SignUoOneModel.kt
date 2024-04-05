package com.buildcart.app.modules.signuoone.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterMobilenu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_mobile_nu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterreferral: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_referral)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOR: String? = MyApp.getInstance().resources.getString(R.string.lbl_or)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_have_an)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLogin: String? = MyApp.getInstance().resources.getString(R.string.lbl_login2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSkipfornow: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip_for_now)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupFourValue: String? = null
)
