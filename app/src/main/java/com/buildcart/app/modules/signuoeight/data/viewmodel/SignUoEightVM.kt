package com.buildcart.app.modules.signuoeight.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuoeight.`data`.model.SignUoEightModel
import com.buildcart.app.modules.signuoeight.`data`.model.SignUoEightRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SignUoEightVM : ViewModel(), KoinComponent {
  val signUoEightModel: MutableLiveData<SignUoEightModel> = MutableLiveData(SignUoEightModel())

  var navArguments: Bundle? = null

  val signUoEightList: MutableLiveData<MutableList<SignUoEightRowModel>> =
      MutableLiveData(mutableListOf())
}
