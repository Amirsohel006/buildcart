package com.buildcart.app.modules.signuoeight.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoEightModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentOptions: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_payment_options)
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
  var txtCODCashonD: String? = MyApp.getInstance().resources.getString(R.string.msg_cod_cash_on_d)

)
