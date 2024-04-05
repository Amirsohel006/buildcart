package com.buildcart.app.modules.ordersthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersthree.`data`.model.OrdersThreeModel
import org.koin.core.KoinComponent

class OrdersThreeVM : ViewModel(), KoinComponent {
  val ordersThreeModel: MutableLiveData<OrdersThreeModel> = MutableLiveData(OrdersThreeModel())

  var navArguments: Bundle? = null
}
