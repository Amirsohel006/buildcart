package com.buildcart.app.modules.frame307.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class Frame307Model(
  /**
   * TODO Replace with dynamic value
   */
  var txtTransactionSuc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_transaction_suc)

)
