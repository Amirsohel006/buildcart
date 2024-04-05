package com.buildcart.app.modules.signuoeighteen.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoEighteenModel(
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
  var txtNetbanking: String? = MyApp.getInstance().resources.getString(R.string.lbl_netbanking)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUPI: String? = MyApp.getInstance().resources.getString(R.string.lbl_upi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCODCashonD: String? = MyApp.getInstance().resources.getString(R.string.msg_cod_cash_on_d)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCreditDebit: String? = MyApp.getInstance().resources.getString(R.string.msg_credit_debit)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaypal: String? = MyApp.getInstance().resources.getString(R.string.lbl_paypal)

)
