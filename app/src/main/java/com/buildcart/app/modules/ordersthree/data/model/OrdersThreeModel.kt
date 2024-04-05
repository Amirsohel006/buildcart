package com.buildcart.app.modules.ordersthree.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class OrdersThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAddNewAddress: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_add_new_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddAddress: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtContactInfo: String? = MyApp.getInstance().resources.getString(R.string.lbl_contact_info)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtName: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPhoneNumber: String? = MyApp.getInstance().resources.getString(R.string.msg_phone_number)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMobileNo: String? = MyApp.getInstance().resources.getString(R.string.lbl_7477494990)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDeliveryAddres: String? =
      MyApp.getInstance().resources.getString(R.string.msg_delivery_addres)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupThirty: String? = MyApp.getInstance().resources.getString(R.string.lbl_pincode)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupTwentyNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_city)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTypeofAddress: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_type_of_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupNinetyValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupNinetyOneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupNinetyTwoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupNinetyThreeValue: String? = null
)
