package com.buildcart.app.modules.signuonine.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoNineModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSavedAddress: String? = MyApp.getInstance().resources.getString(R.string.lbl_saved_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSavedAddressOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_saved_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDinesh: String? = MyApp.getInstance().resources.getString(R.string.lbl_dinesh)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNewcozyPGFive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_new_cozy_pg_5)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddNewAddress: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_add_new_address)

)
