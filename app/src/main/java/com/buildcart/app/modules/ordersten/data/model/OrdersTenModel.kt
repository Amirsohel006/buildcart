package com.buildcart.app.modules.ordersten.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class OrdersTenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderdetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_order_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDeliveryto: String? = MyApp.getInstance().resources.getString(R.string.lbl_delivery_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_sgs_pg_2nd_st)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAshishB: String? = MyApp.getInstance().resources.getString(R.string.lbl_ashish_b)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMobileNo: String? = MyApp.getInstance().resources.getString(R.string.lbl_9487349483)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProduct: String? = MyApp.getInstance().resources.getString(R.string.lbl_product)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderID2347: String? = MyApp.getInstance().resources.getString(R.string.msg_order_id_23472)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDesignTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_design_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCreamColour: String? = MyApp.getInstance().resources.getString(R.string.lbl_cream_colour)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQtyCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty_100)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOldPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_18299)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_176302)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_price_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice1Item: String? = MyApp.getInstance().resources.getString(R.string.msg_price_1_item)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_170002)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDeliveryCharge: String? =
      MyApp.getInstance().resources.getString(R.string.msg_delivery_charge)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_630)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalAmount: String? = MyApp.getInstance().resources.getString(R.string.lbl_total_amount)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_17630)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStatus: String? = MyApp.getInstance().resources.getString(R.string.lbl_status)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDelivered: String? = MyApp.getInstance().resources.getString(R.string.lbl_delivered)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.msg_delivery_date)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.msg_delivery_time)

)
