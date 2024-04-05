package com.buildcart.app.modules.orderssix.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.orderssix.`data`.model.OrdersSixModel
import org.koin.core.KoinComponent

class OrdersSixVM : ViewModel(), KoinComponent {
  val ordersSixModel: MutableLiveData<OrdersSixModel> = MutableLiveData(OrdersSixModel())

  var navArguments: Bundle? = null
}
