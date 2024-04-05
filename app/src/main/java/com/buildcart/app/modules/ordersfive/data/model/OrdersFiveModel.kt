package com.buildcart.app.modules.ordersfive.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class OrdersFiveModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTrackOrder: String? = MyApp.getInstance().resources.getString(R.string.lbl_track_order)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_26_may_tue)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_04_35pm)
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
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.msg_sgs_pg_2nd_st)

)
