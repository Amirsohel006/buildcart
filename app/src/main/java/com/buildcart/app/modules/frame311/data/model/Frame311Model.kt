package com.buildcart.app.modules.frame311.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Frame311Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMobileNo: String? = MyApp.getInstance().resources.getString(R.string.lbl_9373636366)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.lbl_rahul_gmail_com)
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
  var txtFavorites: String? = MyApp.getInstance().resources.getString(R.string.lbl_favorites)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtChangeAddress: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_change_address)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReferrals: String? = MyApp.getInstance().resources.getString(R.string.lbl_referrals)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHelpFAQs: String? = MyApp.getInstance().resources.getString(R.string.lbl_help_faqs)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrivacypolicy: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_privacy_policy)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAboutUs: String? = MyApp.getInstance().resources.getString(R.string.lbl_about_us)

)
