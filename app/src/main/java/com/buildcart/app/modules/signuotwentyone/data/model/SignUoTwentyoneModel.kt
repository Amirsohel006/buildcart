package com.buildcart.app.modules.signuotwentyone.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoTwentyoneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmAddress: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_confirm_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddress: String? = MyApp.getInstance().resources.getString(R.string.lbl_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderSummary: String? = MyApp.getInstance().resources.getString(R.string.lbl_order_summary)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPayment: String? = MyApp.getInstance().resources.getString(R.string.lbl_payment)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSavedAddress: String? = MyApp.getInstance().resources.getString(R.string.lbl_saved_address)
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
