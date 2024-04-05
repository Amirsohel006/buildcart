package com.buildcart.app.modules.signuotwentyone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuotwentyone.`data`.model.SignUoTwentyoneModel
import org.koin.core.KoinComponent

class SignUoTwentyoneVM : ViewModel(), KoinComponent {
  val signUoTwentyoneModel: MutableLiveData<SignUoTwentyoneModel> =
      MutableLiveData(SignUoTwentyoneModel())

  var navArguments: Bundle? = null
}
