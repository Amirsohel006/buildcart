package com.buildcart.app.modules.signuotwelve.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuotwelve.`data`.model.SignUoTwelveModel
import org.koin.core.KoinComponent

class SignUoTwelveVM : ViewModel(), KoinComponent {
  val signUoTwelveModel: MutableLiveData<SignUoTwelveModel> = MutableLiveData(SignUoTwelveModel())

  var navArguments: Bundle? = null
}
