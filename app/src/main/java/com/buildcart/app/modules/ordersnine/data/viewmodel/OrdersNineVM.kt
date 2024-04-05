package com.buildcart.app.modules.ordersnine.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersnine.`data`.model.OrdersNineModel
import org.koin.core.KoinComponent

class OrdersNineVM : ViewModel(), KoinComponent {
  val ordersNineModel: MutableLiveData<OrdersNineModel> = MutableLiveData(OrdersNineModel())

  var navArguments: Bundle? = null
}
