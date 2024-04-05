package com.buildcart.app.modules.signuofifteen.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoFifteenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMyProfile: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_profile)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup421Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etMobileNoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup423Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup424Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etZipcodeValue: String? = null
)
