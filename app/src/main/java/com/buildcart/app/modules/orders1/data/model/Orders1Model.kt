package com.buildcart.app.modules.orders1.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Orders1Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderID2347: String? = MyApp.getInstance().resources.getString(R.string.msg_order_id_2347)
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
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_176302)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQtyCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_qty_100)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_4_5)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderDispatche: String? =
      MyApp.getInstance().resources.getString(R.string.msg_order_dispatche)

)
