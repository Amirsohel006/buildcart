package com.buildcart.app.modules.signuotwenty.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.signuotwenty.`data`.model.SignUoTwentyModel
import org.koin.core.KoinComponent

class SignUoTwentyVM : ViewModel(), KoinComponent {
  val signUoTwentyModel: MutableLiveData<SignUoTwentyModel> = MutableLiveData(SignUoTwentyModel())

  var navArguments: Bundle? = null
}
