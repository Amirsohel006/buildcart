package com.buildcart.app.modules.signuofourteen.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class SignUoFourteenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtReferrals: String? = MyApp.getInstance().resources.getString(R.string.lbl_referrals)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalReferrals: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_total_referrals)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_03)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReferralcode: String? = MyApp.getInstance().resources.getString(R.string.lbl_referral_code)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDKFJFK567GDKDK: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_dkfjfk567gdkdk)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSharevia: String? = MyApp.getInstance().resources.getString(R.string.lbl_share_via)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup474Value: String? = null
)
