package com.buildcart.app.modules.ordersnine.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class OrdersNineModel(
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
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul)
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
  var txtGroupEightyEight: String? = MyApp.getInstance().resources.getString(R.string.lbl_pincode)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupEightySeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_city)
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
  var txtHomeThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategories: String? = MyApp.getInstance().resources.getString(R.string.lbl_categories)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyOrders: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_orders)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyCart: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_cart)
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
