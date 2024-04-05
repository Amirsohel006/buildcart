package com.buildcart.app.modules.ordersone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersone.`data`.model.OrdersOneModel
import org.koin.core.KoinComponent

class OrdersOneVM : ViewModel(), KoinComponent {
  val ordersOneModel: MutableLiveData<OrdersOneModel> = MutableLiveData(OrdersOneModel())

  var navArguments: Bundle? = null
}
