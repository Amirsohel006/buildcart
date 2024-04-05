package com.buildcart.app.modules.ordersseven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersseven.`data`.model.OrdersSevenModel
import org.koin.core.KoinComponent

class OrdersSevenVM : ViewModel(), KoinComponent {
  val ordersSevenModel: MutableLiveData<OrdersSevenModel> = MutableLiveData(OrdersSevenModel())

  var navArguments: Bundle? = null
}
