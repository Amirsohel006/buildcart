package com.buildcart.app.modules.ordersfour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersfour.`data`.model.OrdersFourModel
import org.koin.core.KoinComponent

class OrdersFourVM : ViewModel(), KoinComponent {
  val ordersFourModel: MutableLiveData<OrdersFourModel> = MutableLiveData(OrdersFourModel())

  var navArguments: Bundle? = null
}
