package com.buildcart.app.modules.frame309.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Frame309Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtTransactionSuc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_transaction_suc)

)
