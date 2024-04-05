package com.buildcart.app.modules.ordersfive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.ordersfive.`data`.model.OrdersFiveModel
import com.buildcart.app.modules.ordersfive.`data`.model.OrdersFiveRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class OrdersFiveVM : ViewModel(), KoinComponent {
  val ordersFiveModel: MutableLiveData<OrdersFiveModel> = MutableLiveData(OrdersFiveModel())

  var navArguments: Bundle? = null

  val ordersFiveList: MutableLiveData<MutableList<OrdersFiveRowModel>> =
      MutableLiveData(mutableListOf())
}
