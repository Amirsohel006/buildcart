package com.buildcart.app.modules.ordersten.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersten.`data`.model.OrdersTenModel
import org.koin.core.KoinComponent

class OrdersTenVM : ViewModel(), KoinComponent {
  val ordersTenModel: MutableLiveData<OrdersTenModel> = MutableLiveData(OrdersTenModel())

  var navArguments: Bundle? = null
}
