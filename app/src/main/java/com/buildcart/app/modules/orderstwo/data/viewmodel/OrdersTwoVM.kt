package com.buildcart.app.modules.orderstwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.orderstwo.`data`.model.OrdersTwoModel
import org.koin.core.KoinComponent

class OrdersTwoVM : ViewModel(), KoinComponent {
  val ordersTwoModel: MutableLiveData<OrdersTwoModel> = MutableLiveData(OrdersTwoModel())

  var navArguments: Bundle? = null
}
