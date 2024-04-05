package com.buildcart.app.modules.orderseight.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.orderseight.`data`.model.OrdersEightModel
import org.koin.core.KoinComponent

class OrdersEightVM : ViewModel(), KoinComponent {
  val ordersEightModel: MutableLiveData<OrdersEightModel> = MutableLiveData(OrdersEightModel())

  var navArguments: Bundle? = null
}
