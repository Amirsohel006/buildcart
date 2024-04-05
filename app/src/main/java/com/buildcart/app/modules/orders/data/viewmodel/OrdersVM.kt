package com.buildcart.app.modules.orders.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.orders.`data`.model.OrdersModel
import org.koin.core.KoinComponent

class OrdersVM : ViewModel(), KoinComponent {
  val ordersModel: MutableLiveData<OrdersModel> = MutableLiveData(OrdersModel())

  var navArguments: Bundle? = null
}
