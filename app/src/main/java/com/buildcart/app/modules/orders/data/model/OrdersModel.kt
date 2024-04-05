package com.buildcart.app.modules.orders.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class OrdersModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMyOrders: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_orders)

)
