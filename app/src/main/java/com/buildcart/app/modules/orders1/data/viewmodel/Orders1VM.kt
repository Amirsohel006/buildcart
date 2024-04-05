package com.buildcart.app.modules.orders1.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.orders1.`data`.model.Orders1Model
import org.koin.core.KoinComponent

class Orders1VM : ViewModel(), KoinComponent {
  val orders1Model: MutableLiveData<Orders1Model> = MutableLiveData(Orders1Model())

  var navArguments: Bundle? = null
}
