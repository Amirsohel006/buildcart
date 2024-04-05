package com.buildcart.app.modules.mycart.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class MyCartModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMyCart: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_cart)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProductAdded: String? = MyApp.getInstance().resources.getString(R.string.lbl_product_added)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderID23475: String? =
      MyApp.getInstance().resources.getString(R.string.msg_order_id_23475)
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
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup434: String? = MyApp.getInstance().resources.getString(R.string.lbl_100)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_17000)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddMoreItems: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_add_more_items)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnteryourcoup: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_your_coup)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtViewCoupons: String? = MyApp.getInstance().resources.getString(R.string.lbl_view_coupons)
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
  var txtPayableAmount: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_payable_amount)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_17630)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup379Value: String? = null
)
