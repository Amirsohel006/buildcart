package com.buildcart.app.modules.screentwelve.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.screentwelve.`data`.model.ScreenTwelveModel
import org.koin.core.KoinComponent

class ScreenTwelveVM : ViewModel(), KoinComponent {
  val screenTwelveModel: MutableLiveData<ScreenTwelveModel> = MutableLiveData(ScreenTwelveModel())

  var navArguments: Bundle? = null
}
